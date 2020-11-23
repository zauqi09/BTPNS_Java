import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Tugas1Client {
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
    try{
        s = new Socket(server, port);
        dis =new DataInputStream(s.getInputStream());
        dout=new DataOutputStream(s.getOutputStream());
        do {
            System.out.print("Message : ");
            msg = keyboard.nextLine();
            sendMSG(msg);
            receiveMSG();
        } while (!msg.equals("EXIT"));
        s.close();
        dis.close();
        dout.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  public static void sendMSG(String msg){
    try {
        
        dout.writeUTF(msg);
        dout.flush();
    } catch (IOException e) {
        e.printStackTrace();
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

		
	
