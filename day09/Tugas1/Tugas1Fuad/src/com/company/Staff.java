package com.company;

import java.util.ArrayList;

public class Staff extends Worker{
    int TJmakan = 20000;
    ArrayList<String> email = new ArrayList<>();

    public Staff(int IDKaryawan, String nama, String newemail){
        System.out.println("Creating a Staff ...");
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.email.add(newemail);
    }

    //class setter and getter
    public int getTJmakan() {
        return TJmakan;
    }
    public int getTJPulsa() {
        return this.TJpulsa;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    //inheritance abstract class
    public String getName() {
        return this.nama;
    }
    public int getGajiTotal() {
        return this.GajiTotal;
    }
    public int getIDKaryawan() {
        return this.IDKaryawan;
    }
    public int getAbsensi() {
        return this.absensi;
    }
    public void tambahAbsensi(int id){
        if (id == this.IDKaryawan){
            this.absensi = this.absensi +1;
        }
    }
    public String getJabatan(){
        this.Jabatan = "Staff";
        return this.Jabatan;
    }

    //class method
    public void HitungTJmakan() {
            this.TJmakan = TJmakan * this.absensi;
    }

    public void hitungGajiTotal(){
            this.GajiTotal=this.gajipokok + this.TJmakan + this.TJpulsa;
    }
}

