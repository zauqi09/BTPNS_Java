public abstract class Worker{
    public int IDKaryawan;
    String nama;
    int absensi = 20;
    int gajipokok = 4000000;
    int GajiTotal;
    String Jabatan;
    public abstract String getName();
    public abstract String getJabatan();
    public abstract int getIDKaryawan();
    public abstract int getAbsensi();
    public abstract int getGajiTotal();
    public abstract void tambahAbsensi(int id);
    public abstract void hitungGajiTotal(int id);
}
