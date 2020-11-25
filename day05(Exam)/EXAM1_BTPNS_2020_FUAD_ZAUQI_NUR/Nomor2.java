public class Nomor2 {
    int tahun;
    String merk;
    int kecepatan;

    public Nomor2(int newTahun, String newMerk, int newKecepatan){
        tahun=newTahun;
        merk=newMerk;
        kecepatan=newKecepatan;
    }

    void TambahKecepatan(int increment) {
        kecepatan = kecepatan + increment;   
        System.out.println("Kecepatan Saat Ini : "+kecepatan);
    }

    void KurangiKecepatan(int decrement) {
        kecepatan = kecepatan - decrement;   
        System.out.println("Kecepatan Saat Ini : "+kecepatan);
    }
}
