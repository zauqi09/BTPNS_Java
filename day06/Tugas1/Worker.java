class Worker {
    private int IDKaryawan;
    private String nama;
    private int absensi;
    public Worker(int IDKaryawan, String nama, int absensi) {
        System.out.println("Constructing an Employee");
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.absensi = absensi;
    }
    public String getName() {
        return nama;
    }
    public int getIDKaryawan() {
        return IDKaryawan;
    }
    public int getAbsensi() {
        return absensi;
    }
    public void tambahAbsensi(int id){
        if (id == this.IDKaryawan){
            this.absensi = this.absensi +1;
        }
    }
}
