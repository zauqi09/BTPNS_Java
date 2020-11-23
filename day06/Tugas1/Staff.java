public class Staff extends Worker{
    private String jabatan;
    public Staff(int IDKaryawan, String nama, int absensi, String jabatan){
        super(IDKaryawan, nama, absensi);
        this.jabatan = jabatan;
    }
    public String getJabatan() {
        return jabatan;
    }
    public int compareTo(Staff compareID) {
    
        int compareIDSort = ((Staff ) compareID).getIDKaryawan(); 
        
        //ascending order
        return super.getIDKaryawan() - compareIDSort;
        
        //descending order
        //return compareQuantity - this.quantity;
        
    }  
    public void tambahAbsensi(int id){
        super.tambahAbsensi(id);
    }
}
