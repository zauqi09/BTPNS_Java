package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Staff> staff=new ArrayList<Staff>();
    public static ArrayList<Manager> manager=new ArrayList<Manager>();
    public static void main(String args[]) {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Tambah Manager atau Staff\n2. Create JSON Format and Write to File\n3. Read JSON Format from a File\n\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            Menu(keyInput);
        } while (keyInput != 0);
    }
    //clrscrn
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    //press enter to continue
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
    //Menu
    public static void Menu(int key){
        switch (key) {
            case 1:
                SubMenu1();
                break;
            case 2:
                SubMenu2();
                break;
            case 3:
                SubMenu3();
                break;
            default:
                break;
        }
    }
    //submenu1
    public static void SubMenu1(){
        int keyInput;
        do {
            clearScreen();
            //submenu
            System.out.println("SUBMENU\n1. Tambah Manager\n2. Tambah Staff\n\n9. Back to Main Menu\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    createManager();
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    createStaff();
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
        } while (keyInput != 9);

    }
    //submenu2
    public static void SubMenu2(){
        int keyInput;
        do {
            clearScreen();
            //submenu
            System.out.println("SUBMENU\n1. Create Manager.txt\n2. Create  Staff.txt\n\n9. Back to Main Menu\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    HitungManager();
                    createJSONManager();
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    HitungStaff();
                    createJSONStaff();
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
        } while (keyInput != 9);

    }
    //submenu3
    public static void SubMenu3(){
        int keyInput;
        do {
            clearScreen();
            //submenu
            System.out.println("SUBMENU\n1. Read File Manager\n2. Read File Staff\n\n9. Back to Main Menu\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    System.out.print("Masukan nama File : ");
                    String filename1 = keyboard.nextLine();
                    readJSONManager(filename1);
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    System.out.print("Masukan nama File : ");
                    String filename2 = keyboard.nextLine();
                    readJSONStaff(filename2);
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
        } while (keyInput != 9);

    }
    //readJSONmanager
    public static void readJSONManager(String filename){
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

        } catch (IOException e) {
            e.printStackTrace();
        }
        Object obj=JSONValue.parse(textfile);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray elm = (JSONArray) jsonObject.get("manager");
        for (int i = 0, size = elm.size(); i < size; i++)
        {
            JSONObject objectInArray = (JSONObject)elm.get(i);
            System.out.println("id : "+objectInArray.get("id"));
            System.out.println("nama : "+objectInArray.get("nama"));
            System.out.println("telepon : "+objectInArray.get("telepon"));
            System.out.println("tunjangan pulsa : "+objectInArray.get("tunjangan pulsa"));
            System.out.println("tunjangan transport : "+objectInArray.get("tunjangan transport"));
            System.out.println("tunjangan entertaint : "+objectInArray.get("tunjangan entertaint"));
            System.out.println("total gaji : "+objectInArray.get("total gaji")+"\n");
        }
    }

    //readJSONstaff
    public static void readJSONStaff(String filename){
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

        } catch (IOException e) {
            e.printStackTrace();
        }
        Object obj=JSONValue.parse(textfile);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray elm = (JSONArray) jsonObject.get("staff");
        for (int i = 0, size = elm.size(); i < size; i++)
        {
            JSONObject objectInArray = (JSONObject)elm.get(i);
            System.out.println("id : "+objectInArray.get("id"));
            System.out.println("nama : "+objectInArray.get("nama"));
            System.out.println("email : "+objectInArray.get("email"));
            System.out.println("tunjangan pulsa : "+objectInArray.get("tunjangan pulsa"));
            System.out.println("tunjangan makan : "+objectInArray.get("tunjangan makan"));
            System.out.println("total gaji : "+objectInArray.get("total gaji")+"\n");
        }
    }

    //create staff
    public static void createStaff(){
        clearScreen();
        System.out.println("Tambah Staff");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Email : ");
            String email = keyboard.nextLine();
            staff.add(new Staff(id, nama,email));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //create manager
    public static void createManager(){
        clearScreen();
        System.out.println("Tambah Manager");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Telepon : ");
            String telepon = keyboard.nextLine();
            manager.add(new Manager(id, nama,telepon));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createJSONManager(){
        JSONArray arr = new JSONArray();
        JSONObject employees = new JSONObject();
        for (Manager obj: manager){
            JSONObject obj1=new JSONObject();
            obj1.put("total gaji",obj.getGajiTotal());
            obj1.put("tunjangan entertaint",obj.getTJEntertaint());
            obj1.put("tunjangan transport",obj.getTJTransport());
            obj1.put("tunjangan pulsa",obj.getTJPulsa());
            obj1.put("telepon",obj.getTelepon().get(0));
            obj1.put("nama",obj.getName());
            obj1.put("id",obj.getIDKaryawan());

            arr.add(obj1);
            employees.put("manager",arr);

        }
        try {
            FileWriter writer = new FileWriter("Manager.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            String jsonText = JSONValue.toJSONString(employees);
            System.out.println(jsonText);
            buffer.write(jsonText);
            buffer.close();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createJSONStaff(){
        JSONArray arr = new JSONArray();
        JSONObject employees = new JSONObject();
        for (Staff obj: staff){
            JSONObject obj1=new JSONObject();
            obj1.put("total gaji",obj.getGajiTotal());
            obj1.put("tunjangan makan",obj.getTJmakan());
            obj1.put("tunjangan pulsa",obj.getTJPulsa());
            obj1.put("email",obj.getEmail().get(0));
            obj1.put("nama",obj.getName());
            obj1.put("id",obj.getIDKaryawan());

            arr.add(obj1);
            employees.put("staff",arr);
        }
        try {
            FileWriter writer = new FileWriter("Staff.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            String jsonText = JSONValue.toJSONString(employees);
            System.out.println(jsonText);
            buffer.write(jsonText);
            buffer.close();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //hitung tunjangan staff
    public static void HitungStaff(){
        try {
            for (int i = 0; i < staff.size(); i++)
            {
                staff.get(i).HitungTJmakan();
                staff.get(i).hitungGajiTotal();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //hitung tunjuangan manager
    public static void HitungManager(){
        try {
            for (int i = 0; i < manager.size(); i++)
            {
                manager.get(i).HitungTJTransport();
                manager.get(i).HitungTJEntertaint(0);
                manager.get(i).hitungGajiTotal();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }






}
