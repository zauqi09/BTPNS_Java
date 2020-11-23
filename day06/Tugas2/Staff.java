public class Staff extends Worker{
    private String jabatan;
    public Staff(int IDKaryawan, String nama, int absensi, String jabatan){
        super(IDKaryawan, nama, absensi);
        this.jabatan = jabatan;
    }
    public String getJabatan() {
        return this.jabatan; 
    public int compareTo(Staff compareID) {
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
    public void tambahAbsensi(int id){
        if (id == this.IDKaryawan){
            this.absensi = this.absensi +1;
        }
    }
}
