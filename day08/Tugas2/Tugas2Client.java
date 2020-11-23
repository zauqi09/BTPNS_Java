import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tugas2Client {
    public static Scanner keyboard = new Scanner(System.in);
    public static Socket s;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static ServerSocket ss;
    public static int port;
    public static String server;
    public static String msg;
    public static boolean LoggedIn = false;
    public static List<String> listmahasiswa = new ArrayList<String>();
    public static void main(String[] args) {
        propLoad(args[0]);
        do {
            clearScreen();
            System.out.println("LOGIN");
            System.out.print("Username : ");
            String username = keyboard.nextLine();
            System.out.print("Password : ");
            String password = keyboard.nextLine();
            try {
                doLogin(username, password);
                if (LoggedIn) {
                    System.out.println("Berhasil Login");
                    pressAnyKeyToContinue();
                    menu();
                } else {
                    System.out.println("Gagal Login");
                    pressAnyKeyToContinue();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (LoggedIn != true);
    }

    public static void menu() throws UnknownHostException, IOException {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Connect to Socket\n2. Send Data to Server\n3. Close Socket\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    clearScreen();
                    System.out.println("Connecting to Socket");
                    s = new Socket(server, port);
                    System.out.println("Connected!");
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Input File Name");
                    String filename = keyboard.nextLine();
                    trxData(filename);
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Closing the Socket");
                    s.close();
                    System.out.println("Closed!");
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
        } while (keyInput != 0);
    }

    public static void trxData(String filename){
        String textfile = "";
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int i;
            while ((i = br.read()) != -1) {

                textfile += (char) i;
            }
            fr.close();
            br.close();
            
            dis =new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            sendMSG(String.format(textfile));
            receiveMSG();
            dis.close();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public static void pressAnyKeyToContinue()
    { 
       System.out.println("Press Enter key to continue...");
       try
       {
           System.in.read();
       }  
       catch(Exception e)
       {}  
}

  public static void sendMSG(String msg){
    try {
        
        dout.writeUTF(msg);
        dout.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  public static void doLogin(String email, String pswd) throws IOException {
    String emailTemp="";
    String pswdTemp="";
    boolean emailCorrect = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).matches();
    boolean pswdCorrect = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$").matcher(pswd).matches();
    if (emailCorrect && pswdCorrect){
        FileReader username=new FileReader("username.txt");
        FileReader password=new FileReader("password.txt");
        BufferedReader uname=new BufferedReader(username);
        BufferedReader pw=new BufferedReader(password);
        int i;
        while((i=uname.read())!=-1){
            emailTemp+=(char)i;
        }
        while((i=pw.read())!=-1){
            pswdTemp+=(char)i;
        }

        if (Pattern.matches(email, emailTemp) && Pattern.matches(pswd, pswdTemp)){
            LoggedIn = true;
        } else {
            System.out.println("Email atau Password salah");
        }
        uname.close();
        pw.close();
        username.close();
        password.close();
    }else {
        System.out.println("Password harus lebih dari 8 character, ada huruf besar dan kecil, memiliki special character");
    }

}
  public static void receiveMSG(){
    try {
        //receive
        System.out.println("waiting the message ...");
        
        String str=(String)dis.readUTF(); 
        System.out.println("message from Server "+str);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

    public static void returnportserver(String newserver ,int newport){
        port = newport;
        server = newserver;
    }

  public static void propLoad(String file){
    Properties prop = new Properties();
	InputStream input = null;
    try {

		input = new FileInputStream(file);

		// load a properties file
		prop.load(input);

        // get the property value and print it out
        
        returnportserver(prop.getProperty("server"),Integer.parseInt(prop.getProperty("port")));
        //serversocket
        
    } catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
  }
}

		
	
