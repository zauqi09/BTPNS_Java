package org.example.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Staff extends Worker{
    private static final AtomicLong counter = new AtomicLong();
    private int TJmakan= 100000;
    private ArrayList<String> email = new ArrayList<>();

    public Staff() {
        this.IDKaryawan = counter.incrementAndGet();
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    public int getGajipokok() {
        return gajipokok;
    }

    public void setGajipokok(int gajipokok) {
        this.gajipokok = gajipokok;
    }

    public int getTJpulsa() {
        return TJpulsa;
    }

    public void setTJpulsa(int TJpulsa) {
        this.TJpulsa = TJpulsa;
    }
    //class setter and getter
    public int getTJmakan() {
        return TJmakan;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String name) {
        this.nama = name;
    }
    public Long getIDKaryawan() {
        return this.IDKaryawan;
    }
    public int getAbsensi() {
        return this.absensi;
    }

    //class method
    public void HitungTJmakan(Long id) {
        if (id == this.IDKaryawan){
            this.TJmakan = TJmakan * this.absensi;
        }
    }
    @Override
    public String toString() {
        return "Staff [id=" + this.IDKaryawan + ", nama=" + this.nama + ", absensi=" + this.absensi
                + ", tunjangan_pulsa=" + this.TJpulsa + ", tunjangan_makan="
                + this.TJmakan + ", gaji_pokok=" + this.gajipokok + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Staff other = (Staff) obj;
        if (this.IDKaryawan != other.IDKaryawan)
            return false;
        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.IDKaryawan ^ (this.IDKaryawan >>> 32));
        return result;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }


}

