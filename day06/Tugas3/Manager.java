public class Manager extends Worker{
    int tjTransport = 50000;
    int tjEntertaint = 500000;
    public Manager(int IDKaryawan, String nama){
        System.out.println("Creating a Manager ...");
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
    }

    //class setter and getter
    public int getTJTransport() {
        return tjTransport;
    }
    public int getTJEntertaint() {
        return tjEntertaint;
    }

    //inheritance abstract class
    public int compareTo(Manager compareID) {
        int compareIDSort = compareID.IDKaryawan; 
        return this.IDKaryawan - compareIDSort;
    }  
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
    public void HitungTJTransport(int id) {
        if (id == this.IDKaryawan){
            this.tjTransport = this.tjTransport * this.absensi;
        }
    }

    public void HitungTJEntertaint(int id, int ent) {
        if (id == this.IDKaryawan){
            this.tjEntertaint = this.tjEntertaint * ent;
        }
    }

    public void hitungGajiTotal(int id){
        if (id == this.IDKaryawan){
            this.GajiTotal=this.gajipokok + this.tjEntertaint + this.tjTransport;
        }
    }
}
