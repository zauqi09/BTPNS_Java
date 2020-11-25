package org.example.model;
// class abstract Worker
public abstract class Worker{
    Long IDKaryawan;
    String nama;
    int absensi = 20;
    int gajipokok = 5000000;
    int TJpulsa = 50000;

    //method abstract
    public abstract String getNama();
    public abstract Long getIDKaryawan();
    public abstract int getAbsensi();


}

