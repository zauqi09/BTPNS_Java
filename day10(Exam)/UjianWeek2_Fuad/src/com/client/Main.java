package com.client;
import java.io.*;
import java.net.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;


public class Main {
    public static Socket s;
    public static DataOutputStream dout;
    public static int port;
    public static String server;
    public static void main(String[] args) {

        propLoad("./src/com/client/config.properties");
        try {
            sendProcess("./src/com/client/mahasiswa2_fuad.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Shutdown the Server");
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    public static void sendProcess(String filename) throws IOException {
        clearScreen();
        System.out.println("Connecting to Socket");
        s = new Socket(server, port);
        System.out.println("Connected!");
        System.out.println("Prepare to Sending Data");
        trxData(filename);

    }
    public static void trxData(String filename){
        try (FileReader reader = new FileReader(filename))
        {
            JSONParser jsonParser = new JSONParser();
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            String jsonText = JSONValue.toJSONString(obj);
            System.out.println(jsonText);
            dout=new DataOutputStream(s.getOutputStream());
            sendMSG(jsonText);
            dout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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




