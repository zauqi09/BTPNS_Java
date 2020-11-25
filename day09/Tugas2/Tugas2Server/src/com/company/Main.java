package com.company;

import java.io.*;
import java.net.*;
import java.util.*;

import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static Socket s;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static ServerSocket ss;
    public static int port;
    public static String server;
    public static String msg;
    public static boolean LoggedIn = false;
    public static ArrayList<String[]> siswa=new ArrayList<>();
    public static void main(String[] args) {

        propLoad("config.properties");
        try {
            loopserver("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Shutdown the Server");
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



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

            String[] values = textfile.split("\\n");
            JSONArray arr = new JSONArray();
            JSONObject siswa = new JSONObject();
            for (String string : values){
                String[] data = string.split(",");
                JSONObject obj1=new JSONObject();
                for (int j = 0; j<data.length; j++){
                    if (j==0){
                        obj1.put("nama",data[j]);
                    } else if (j==1){
                        obj1.put("nilai fisika",data[j]);
                    } else if (j==2){
                        obj1.put("nilai biologi",data[j]);
                    } else if (j==3){
                        obj1.put("nilai kimia",data[j]);
                    }
                }
                arr.add(obj1);

            }
            siswa.put("siswa",arr);
            String jsonText = JSONValue.toJSONString(siswa);
            System.out.println(jsonText);
            dout=new DataOutputStream(s.getOutputStream());
            sendMSG(jsonText);
            dout.close();
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




