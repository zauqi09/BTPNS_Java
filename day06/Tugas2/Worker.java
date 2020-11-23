abstract class Worker {
    int IDKaryawan;
    String nama;
    int absensi;

    public abstract  String getName();
    public abstract  int getIDKaryawan();
    public abstract  int getAbsensi();
    public  abstract void tambahAbsensi(int id);
}
