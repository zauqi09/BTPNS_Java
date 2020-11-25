package com.server;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.sql.SQLException;
import java.util.Iterator;

public class SocketThread extends Thread{
    public int port;
    public String textfile;
    public static DataInputStream dis;
    public String fullname;
    public String address;
    public String status;
    public int biologi;
    public int physics;
    public int calculus;
    public Conn inputDT;
    public void run() {
        StartServer();
        try {
            decodeStringJSON(textfile);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public SocketThread(int port){
        this.port=port;
    }
    public SocketThread(){
    }
    public void StartServer(){
        try {
            System.out.println("Starting the Server");
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Done!");
            System.out.println("Waiting Client to Connect ...");
            Socket s = ss.accept();
            dis =new DataInputStream(s.getInputStream());
            receiveMSG();
            dis.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void decodeStringJSON(String textfile) throws SQLException {
        Object obj= JSONValue.parse(textfile);
        JSONObject jsonObject = (JSONObject) obj;
        inputDT = new Conn();
        inputDT.start();
        for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            JSONObject elm = (JSONObject) jsonObject.get(key);
            address = String.valueOf(elm.get("address"));
            fullname = String.valueOf(elm.get("fullname"));
            status =String.valueOf(elm.get("status"));
            JSONObject grades = (JSONObject) elm.get("grades");
            biologi = Integer.parseInt(String.valueOf(grades.get("biologi")));
            physics = Integer.parseInt(String.valueOf(grades.get("physics")));
            calculus = Integer.parseInt(String.valueOf(grades.get("calculus")));
            Siswa siswa = new Siswa(fullname,address,status, physics,calculus,biologi);
            siswa.inputData(inputDT);
        }
        inputDT.getConn().close();
    }
    public void receiveMSG(){
        try {
            //receive
            System.out.println("Waiting the data ...");

            textfile=(String)dis.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getTextfile(){
        return this.textfile;
    }
}
