package com.company;

import java.util.ArrayList;

public class Manager extends Worker{
    int tjTransport = 50000;
    int tjEntertaint = 500000;
    ArrayList<String> telepon = new ArrayList<>();
    public Manager(int IDKaryawan, String nama,String newtelepon){
        System.out.println("Creating a Manager ...");
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.telepon.add(newtelepon);
    }
    public int getTJPulsa() {
        return this.TJpulsa;
    }
    public ArrayList<String> getTelepon() {
        return this.telepon;
    }
    //class setter and getter
    public int getTJTransport() {
        return tjTransport;
    }
    public int getTJEntertaint() {
        return tjEntertaint;
    }

    //inheritance abstract class

    public String getName() {
        return this.nama;
    }
    public int getIDKaryawan() {
        return this.IDKaryawan;
    }
    public int getAbsensi() {
        return this.absensi;
    }
    public int getGajiTotal() {
        return this.GajiTotal;
    }
    public void tambahAbsensi(int id){
        if (id == this.IDKaryawan){
            this.absensi = this.absensi +1;
        }
    }
    public String getJabatan(){
        this.Jabatan = "Manager";
        return this.Jabatan;
    }

    //class method
    public void HitungTJTransport() {
            this.tjTransport = this.tjTransport * this.absensi;
    }

    public void HitungTJEntertaint(int ent) {
            this.tjEntertaint = this.tjEntertaint * ent;
    }

    public void hitungGajiTotal(){
            this.GajiTotal=this.gajipokok + this.tjEntertaint + this.tjTransport;
    }
}

