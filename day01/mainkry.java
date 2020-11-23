public class mainkry { //kelas mainkry
    public static void main(String[] args) { //fungsi main pada kelas mainkry
        karyawan kry1 = new karyawan("Fuad Zauqi Nur", "Manager", 10000000); //pembuatan objek dengan memanfaatkan konstruktor
        karyawan kry2 = new karyawan("Erdy Yudhistira", "Supervisor", 7000000); //pembuatan objek dengan memanfaatkan konstruktor
        karyawan kry3 = new karyawan("Fuid Ziaqu Nar", "Staff", 5000000); //pembuatan objek dengan memanfaatkan konstruktor
        kry1.printKaryawan(); //memanggil method printKaryawan untuk objek kry1
        kry2.printKaryawan(); //memanggil method printKaryawan untuk objek kry2
        kry3.printKaryawan(); //memanggil method printKaryawan untuk objek kry3

    }
}
