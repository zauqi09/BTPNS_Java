package com.server;

import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static Support support = new Support();
    public static boolean LoggedIn = false;
    public static Conn jdbc;
    public static ServerSocket ss;
    public static int port;
    public static String server;
    public static FTPClass ftp;
    public static void main(String[] args) throws IOException, SQLException {
        propLoad("./src/com/client/config.properties");
        do {

            support.clearScreen();
            System.out.println("LOGIN");
            System.out.print("Username : ");
            String username = keyboard.nextLine();
            System.out.print("Password : ");
            String password = keyboard.nextLine();
            try {
                Conn connlog = new Conn();
                connlog.start();
                doLogin(username, password, connlog);
                connlog.getConn().close();
                if (LoggedIn) {
                    System.out.println("Berhasil Login");
                    support.pressAnyKeyToContinue();
                    menu();
                    //do something after login
                    System.out.println("Shutdown the Server");

                    System.out.println("Done!");
                } else {
                    System.out.println("Gagal Login");
                    support.pressAnyKeyToContinue();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        } while (!LoggedIn);
        System.out.println("Closing the Connection");
        try {
            jdbc.getConn().close();
            ftp.getFtp().logout();
            ftp.getFtp().disconnect();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Closed!");
    }

    public static void doLogin(String email, String pswd, Conn jdbc) throws IOException {
        boolean emailCorrect = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).matches();
        boolean pswdCorrect = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$").matcher(pswd).matches();
        if (emailCorrect && pswdCorrect) {
            Auth auth = new Auth(email, pswd);
            LoggedIn = auth.Login(email, pswd, jdbc);
        } else {
            System.out.println("Password harus lebih dari 8 character, ada huruf besar dan kecil, memiliki special character");
        }
    }
    public static void propLoad(String file){
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream(file);
            prop.load(input);
            returnportserver(prop.getProperty("server"),Integer.parseInt(prop.getProperty("port")));

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
    public static void returnportserver(String newserver ,int newport){
        port = newport;
        server = newserver;
    }

    public static void menu() throws IOException, SQLException {
        int keyInput;
        do {
            support.clearScreen();
            System.out.println("MENU\n1. Start Socket Server and Client DB\n2. FTP and DB Connection Started\n3. Get Data from FTP Server\n4. Send Data to DB\n5. Input, Edit and Delete Data from DB \n6. Send Report to FTP Server\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput){
                case 1:
                    support.clearScreen();
                    SocketThread thread1 = new SocketThread(port);
                    System.out.println("Starting Thread Socket and Input to DB ...");
                    thread1.start();
                    break;
                case 2:
                    jdbc = new Conn();
                    jdbc.start();
                    ftp = new FTPClass();
                    ftp.Start();
                    System.out.println("DB Connection Started");
                    System.out.println("FTP Connection Started");
                    support.pressAnyKeyToContinue();
                    break;
                case 3:
                    ftp.listDir();
                    System.out.print("Masuk ke directory : ");
                    String dir = keyboard.nextLine();
                    ftp.listDir(dir);
                    System.out.print("Download file : ");
                    String filename = keyboard.nextLine();
                    ftp.Download(filename);
                    support.pressAnyKeyToContinue();
                    break;
                case 4:
                    System.out.print("Pilih File : ");
                    String filechosen = keyboard.nextLine();
                    String filedir = String.format("C:\\Users\\btpnshifted\\Desktop\\"+filechosen);
                    SocketThread inputdata = new SocketThread();
                    try (FileReader reader = new FileReader(filedir))
                    {
                        JSONParser jsonParser = new JSONParser();
                        //Read JSON file
                        Object obj = jsonParser.parse(reader);

                        String jsonText = JSONValue.toJSONString(obj);
                        inputdata.decodeStringJSON(jsonText);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    support.pressAnyKeyToContinue();
                    break;
                case 5:
                    int keyInput5;
                    do{
                        support.clearScreen();
                        System.out.println("MENU\n1. Input Data to DB\n2. Edit Data from dB\n3. Delete Data from DB\n9. Back to Main Menu\n");
                        System.out.print("Pilih Menu : ");
                        keyInput5 = Integer.parseInt(keyboard.nextLine());
                        submenu5(keyInput5);
                    }while(keyInput5!=9);
                    support.pressAnyKeyToContinue();
                    break;
                case 6:
                    Siswa result = new Siswa();
                    result.resultData(jdbc);
                    ftp.Upload("result_fuad.csv");
                    support.pressAnyKeyToContinue();
                    break;
            }
        } while (keyInput != 0);
    }

    public static void submenu5(int keyInput){
        switch (keyInput) {
            case 1:
                support.clearScreen();
                System.out.print("Fullname : ");
                String fullname = keyboard.nextLine();
                System.out.print("Address : ");
                String address = keyboard.nextLine();
                System.out.print("Status : ");
                String status = keyboard.nextLine();
                System.out.print("Physics Grade : ");
                int physics = Integer.parseInt(keyboard.nextLine());
                System.out.print("Calculus Grade : ");
                int calculus = Integer.parseInt(keyboard.nextLine());
                System.out.print("Biology Grade : ");
                int biology = Integer.parseInt(keyboard.nextLine());
                Siswa siswa = new Siswa(fullname, address, status, physics, calculus, biology);
                siswa.inputData(jdbc);
                support.pressAnyKeyToContinue();
                break;
            case 2:
                support.clearScreen();
                Siswa edit = new Siswa();
                edit.showData(jdbc);
                System.out.print("Edit ID Data : ");
                int id = Integer.parseInt(keyboard.nextLine());
                System.out.print("Fullname : ");
                String fullname1 = keyboard.nextLine();
                System.out.print("Address : ");
                String address1 = keyboard.nextLine();
                System.out.print("Status : ");
                String status1 = keyboard.nextLine();
                System.out.print("Physics Grade : ");
                int physics1 = Integer.parseInt(keyboard.nextLine());
                System.out.print("Calculus Grade : ");
                int calculus1 = Integer.parseInt(keyboard.nextLine());
                System.out.print("Biology Grade : ");
                int biology1 = Integer.parseInt(keyboard.nextLine());
                edit.editData(jdbc, id, fullname1, address1, status1, physics1, calculus1, biology1);
                support.clearScreen();
                edit.showData(jdbc);
                support.pressAnyKeyToContinue();
                break;
            case 3:
                support.clearScreen();
                Siswa delete = new Siswa();
                delete.showData(jdbc);
                System.out.print("Delete ID Data : ");
                int id1 = Integer.parseInt(keyboard.nextLine());
                delete.deleteData(jdbc, id1);
                support.clearScreen();
                delete.showData(jdbc);
                support.pressAnyKeyToContinue();
                break;
            default:
                break;
        }
    }
}
