package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static Socket s;
    public static DataOutputStream dout;
    public static DataInputStream dis;
    public static ServerSocket ss;
    public static int port;
    public static String textfile;
    public static String server;
    public static String msg;
    public static boolean LoggedIn = false;
    public static ArrayList<String[]> siswa = new ArrayList<>();
    public static void main(String[] args) {
        propLoad("config.properties");
        menu();
    }

    public static void menu() {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Connect to Socket\n2. Create FileProses.txt\n3. Tampilkan dilayar, Tulis ke File, Connect FTP - Kirim FTP (Multi Threading)\n4. Download dari FTP Server\n5. Close All Connection\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    try {
                        clearScreen();
                        System.out.println("Connecting to Socket");
                        s = new Socket(server, port);
                        System.out.println("Connected!");
                        dis =new DataInputStream(s.getInputStream());
                        dout=new DataOutputStream(s.getOutputStream());
                        receiveMSG();

                        dis.close();
                        dout.close();
                        pressAnyKeyToContinue();

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Creating FileProcess.txt ...");
                    try {
                        createFileProses(textfile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("FileProcess.txt created!");
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    try {
                        clearScreen();
                        System.out.println("Multi Threading Started");
                        multithreading();
                        System.out.println("Done!");
                        pressAnyKeyToContinue();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        clearScreen();
                        System.out.println("Downloading File");
                        Download();
                        System.out.println("Done!");
                        pressAnyKeyToContinue();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        clearScreen();
                        System.out.println("Closing All Connection ...");
                        s.close();
                        System.out.println("Done!");
                        pressAnyKeyToContinue();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        } while (keyInput != 0);
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
    public static void Download(){
        DownloadFTP Download = new DownloadFTP();
        Download.start();
    }
    public static void multithreading(){
        PrintData printData =new PrintData (textfile);
        UploadToFTP uploadFTP = new UploadToFTP();

        printData.start();
        uploadFTP.start();
    }

    public static void createFileProses(String textfile) throws IOException {
        Object obj= JSONValue.parse(textfile);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray elm = (JSONArray) jsonObject.get("siswa");
        FileWriter writer = new FileWriter("FileProses.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0, size = elm.size(); i < size; i++)
        {
            JSONObject objectInArray = (JSONObject)elm.get(i);
            buffer.write("nama : "+objectInArray.get("nama")+"\nnilai fisika : "+objectInArray.get("nilai fisika")+"\nnilai kimia : "+objectInArray.get("nilai kimia")+"\nnilai biologi : "+objectInArray.get("nilai biologi")+"\n\n");
        }
        buffer.close();
        writer.close();
        System.out.println(jsonObject);
    }
    public static void receiveMSG(){
        try {
            //receive
            System.out.println("waiting the data ...");

            //String str=(String)dis.readUTF();
            textfile=(String)dis.readUTF();


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





