public class Siswa { //kelas siswa
    private String nama; //deklarasi variabel instance
    private int nilai; //deklarasi variabel instance
    private String gender; //deklarasi variabel instance
    private String TglLahir; //deklarasi variabel instance

    public Siswa(String nama, int nilai, String gender, String TglLahir){ //konstruktor Siswa dengan parameter nama, nilai, gender, TglLahir
        this.nama = nama; //assign variabel instance dengan parameter konstruktor
        this.nilai = nilai; //assign variabel instance dengan parameter konstruktor
        this.gender = gender; //assign variabel instance dengan parameter konstruktor
        this.TglLahir = TglLahir; //assign variabel instance dengan parameter konstruktor
    }
    public int getNilai(){ //method get nilai 
        return this.nilai;
    }
    public void printSiswa(){ //method printSiswa
        System.out.println("Nama : "+nama); //print nama
        System.out.println("Nilai : "+nilai); //print nilai
        System.out.println("Gender : "+gender); //print gender
        System.out.println("Tanggal Lahir : "+TglLahir); //print TglLahir
    }
    
    public String tingkatan(int umur){ //method tingkatan paramter umur
        String tingkatan; //deklarasi variabel lokal
        if (umur >= 23) { //umur =>23
            return tingkatan = "Kuliah Semester 8"; //return string tingkatan
        } else if (umur >= 22) { //umur >= 22
            return tingkatan = "Kuliah Semester 6"; //return string tingkatan
        } else if (umur >= 21) { //umur >= 21
            return tingkatan = "Kuliah Semester 4"; //return string tingkatan
        } else if (umur >= 20) { //umur >= 20
            return tingkatan = "Kuliah Semester 2"; //return string tingkatan
        } else if (umur >= 19) { //umur >= 19
            return tingkatan = "SMA Kelas 12"; //return string tingkatan
        } else if (umur >= 18) { //umur >= 18
            return tingkatan = "SMA Kelas 11"; //return string tingkatan
        } else { //else
            return tingkatan = "SMA Kelas 10"; //return string tingkatan
        }
    }

    public char index(){ //method index grade
        char grade; //deklarasi variabel lokal
        int testscore = nilai; //testscore diassign nilai(variabel intance)

        if (testscore >= 90) { //if then else berdasarkan jarak nilai
            return grade = 'A'; //return char grade
        } else if (testscore >= 80) { //if then else berdasarkan jarak nilai
            return grade = 'B'; //return char grade
        } else if (testscore >= 70) { //if then else berdasarkan jarak nilai
            return grade = 'C'; //return char grade
        } else if (testscore >= 60) { //if then else berdasarkan jarak nilai
            return grade = 'D'; //return char grade
        } else { //else 
            return grade = 'F'; //return char grade
        }
    }
    
}