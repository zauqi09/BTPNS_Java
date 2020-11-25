package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintData extends Thread{
    String siswa;
    PrintData(String siswa){
        this.siswa=siswa;
    }
    public void run(){
        Object obj= JSONValue.parse(siswa);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray elm = (JSONArray) jsonObject.get("siswa");
        for (int i = 0, size = elm.size(); i < size; i++)
        {
            JSONObject objectInArray = (JSONObject)elm.get(i);
            System.out.println("nama : "+objectInArray.get("nama")+"\nnilai fisika : "+objectInArray.get("nilai fisika")+"\nnilai kimia : "+objectInArray.get("nilai kimia")+"\nnilai biologi : "+objectInArray.get("nilai biologi")+"\n\n");
        }

    }
}
