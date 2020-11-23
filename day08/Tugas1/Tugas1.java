import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Tugas1 {
    public static Scanner keyboard = new Scanner(System.in);
    public static Socket s; 
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static ServerSocket ss;
    public static int port;
    public static String server;
    public static String msg;
  public static void main(String[] args) {
    propLoad(args[0]);
    try {
        ss = new ServerSocket(port);
        s = ss.accept();
        dis =new DataInputStream(s.getInputStream());
        dout=new DataOutputStream(s.getOutputStream());
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    do {
        receiveMSG();
        System.out.print("Message : ");
        msg = keyboard.nextLine();
        sendMSG(msg);
    } while (!msg.equals("EXIT"));
    try {
        ss.close();
    } catch (Exception e) {
        //TODO: handle exception
    }
  }
    public static void receiveMSG(){
        try {
            //receive
            System.out.println("waiting the message ...");
            
            String str=(String)dis.readUTF(); 
            System.out.println("message from Client : "+str);
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

		
	
