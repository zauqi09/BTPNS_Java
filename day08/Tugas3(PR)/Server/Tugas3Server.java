import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tugas3Server {
    public static Scanner keyboard = new Scanner(System.in);
    public static Socket s; 
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static ServerSocket ss;
    public static int port;
    public static String server;
    public static String msg;
    public static boolean LoggedIn = false;
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
                loopserver(args[1]);
                System.out.println("Shutdown the Server");
                ss.close();
                System.out.println("Done!");
            } else {
                System.out.println("Gagal Login");
                pressAnyKeyToContinue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } while (LoggedIn != true);
    
    }
    public static void loopserver(String filename) throws IOException {
        clearScreen();
        System.out.println("Starting the Server");
        ss = new ServerSocket(port);
        System.out.println("Done!");
        for (int i = 0; i < 1000; i++) {
            System.out.println("Waiting Client to Connect ...");
            trxData(filename);
        }
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
            s = ss.accept();
            dout=new DataOutputStream(s.getOutputStream());
            sendMSG(textfile);
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receiveMSG(){
        try {
            //receive
            System.out.println("waiting the message ...");
            
            String textfile=(String)dis.readUTF(); 
            //ArrayList<String[]> siswa = new ArrayList<>();
            String[] values = textfile.split("\\n");
            for (String string : values){
                String[] data = string.split(",");
                for (int i = 0; i<data.length; i++){
                    if (i==0){
                        System.out.println("Nama : "+data[i]);
                    } else if (i==1){
                        System.out.println("Nilai Fisika : "+data[i]);
                    } else if (i==2){
                        System.out.println("Nilai Biologi : "+data[i]);
                    } else if (i==3){
                        System.out.println("Nilai Kimia : "+data[i]);
                    }
                }
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    public static void sendMSG(String msg){
        //send
        try {
            
            dout.writeUTF(msg);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void returnportserver(String newserver ,int newport){
        port = newport;
        server = newserver;
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

		
	
