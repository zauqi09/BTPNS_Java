package org.example.database.model;

import javax.persistence.*;
@Entity
@Table(name = "header")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String fullname;
    String address;
    String status;
    int absensi;

    public Mahasiswa() {}
    public Mahasiswa(String fullname, String address, String status) {
        setFullname(fullname);
        setAddress(address);
        setStatus(status);
        setAbsensi(0);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAbsensi() {
        return absensi;
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mahasiswa other = (Mahasiswa) obj;
        if (this.id != other.id)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + getId() +
                ", fullname='" + fullname  +
                ", address=" + address +
                ", status=" + status +
                ", absensi=" + absensi +
                "}'";
    }
}
