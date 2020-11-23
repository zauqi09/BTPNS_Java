public class Staff extends Worker{
    private int TJmakan = 20000;
    private int TJpulsa = 50000;
    public Staff(int IDKaryawan, String nama){
        System.out.println("Creating a Staff ...");
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
    }

    //class setter and getter
    public int getTJmakan() {
        return TJmakan;
    }

    //inheritance abstract class
    public int compareTo(Staff compareID) {
        int compareIDSort = compareID.IDKaryawan; 
        return this.IDKaryawan - compareIDSort;
    }  
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
    public void HitungTJmakan(int id) {
        if (id == this.IDKaryawan){
            this.TJmakan = TJmakan * this.absensi;
        }
    }

    public void hitungGajiTotal(int id){
        if (id == this.IDKaryawan){
            this.GajiTotal=this.gajipokok + this.TJmakan + this.TJpulsa;
        }
    }
}
