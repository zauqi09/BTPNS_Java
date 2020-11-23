import java.util.*;
class Mahasiswa {
    Integer ID;
    String nama;
    ArrayList<Double> nilai = new ArrayList<>();

    public Mahasiswa(int ID, String newNama, Double bing, Double fis, Double alg){
        this.ID = ID;
        nama = newNama;
        nilai.add(bing);
        nilai.add(fis);
        nilai.add(alg);
    }

    ArrayList<Double> getNilai(){
        return nilai;
    }
    void setNama(String newValue) {
        nama = newValue;
       
    }

    public Integer getID(){
        return Integer.valueOf(this.ID);
    }

    String getNama() {
         return nama;
    } 
    public int compareTo(Mahasiswa compareID) {
        int compareIDSort = compareID.ID; 
        return this.ID - compareIDSort;
    }  

}
