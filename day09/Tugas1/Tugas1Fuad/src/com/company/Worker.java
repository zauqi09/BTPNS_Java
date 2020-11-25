package com.company;

public abstract class Worker{
    public int IDKaryawan;
    String nama;
    int absensi = 1;
    int gajipokok = 4000000;
    int TJpulsa = 50000;
    int GajiTotal;
    String Jabatan;
    public abstract String getName();
    public abstract String getJabatan();
    public abstract int getIDKaryawan();
    public abstract int getTJPulsa();
    public abstract int getAbsensi();
    public abstract int getGajiTotal();
    public abstract void tambahAbsensi(int id);
    public abstract void hitungGajiTotal();
}
