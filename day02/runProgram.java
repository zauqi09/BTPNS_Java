public class runProgram { //kelas runProgram
    public static void main(String[] args) { //main class static
        //Siswa 1
        TglLahir lahirsiswa1 = new TglLahir(5,8,1997); //pembuatan objek tgl lahir
        Siswa siswa1 = new Siswa("Fuad Zauqi Nur",85,"Laki-laki", lahirsiswa1.toString()); //pembuatan objek siswa
        siswa1.printSiswa(); //print siswa
        System.out.println("Umur : "+lahirsiswa1.Umur()); //pemanggilan method Umur pada tgllahir
        System.out.println("Grade : "+ siswa1.index()); //pemanggilan method index pada siswa
        System.out.println("Kelas/Semester: "+ siswa1.tingkatan(lahirsiswa1.Umur())); //pemanggilan method tingkatan pada siswa
        System.out.println("History :"); 
        lahirsiswa1.LoopUmur(lahirsiswa1.getYear()); //pemanggilan method loopUmur
        System.out.println();

        //Siswa 2
        TglLahir lahirsiswa2 = new TglLahir(6,2,2001); //pembuatan objek tgl lahir
        Siswa siswa2 = new Siswa("Lin Ulfah Minnati",65,"Perempuan", lahirsiswa2.toString()); //pembuatan objek siswa
        siswa2.printSiswa(); //print siswa
        System.out.println("Umur : "+lahirsiswa2.Umur()); //pemanggilan method Umur pada tgllahir
        System.out.println("Grade : "+ siswa2.index()); //pemanggilan method index pada siswa
        System.out.println("Kelas/Semester: "+ siswa2.tingkatan(lahirsiswa2.Umur())); //pemanggilan method tingkatan pada siswa
        System.out.println("History :");
        lahirsiswa2.LoopUmur(lahirsiswa2.getYear()); //pemanggilan method loopUmur
        System.out.println(); 
    }
}
