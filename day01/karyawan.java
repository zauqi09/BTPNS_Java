class karyawan { //inisialisasi kelas karyawan
    String nama; //deklarasi variabel nama tipe data string
    String jabatan; //deklarasi variabel jabatan tipe data string
    int gaji; //deklarasi variabel gaji tipe data integer
    public karyawan(String newNama, String newJB, int newGaji){ //konstruktor karyawan dengan 3 parameter
         nama = newNama; //variabel nama di assign dengan variabel paramter newNama
         jabatan = newJB; //variabel jabatan di assign dengan variabel paramter newJB
         gaji = newGaji; //variabel gaji di assign dengan variabel paramter newGaji
    }

    void setNama(String newValue) { //method setNama untuk set variabel nama dengan variabel parameter newValue
        nama = newValue;
       
    }

    String getNama() { //method getNama untuk mengembalikan nilai String nama
         return nama;
    }

    void setJB(String newValue) { //method setJB untuk set variabel jabatan dengan variabel parameter newValue
        jabatan = newValue;
    }

    String getJB() { //method getNama untuk mengembalikan nilai String jabatan
         return jabatan;
    }

    void setGaji(int newValue) { //method setGaji untuk set variabel gaji dengan variabel parameter newValue
         gaji = newValue;
    }

    int getGaji() { //method getGaji untuk mengembalikan nilai int gaji
         return gaji;
    }

    void printKaryawan() { //method print objek karyawan
        System.out.println();
        System.out.println(" Nama : " + getNama()); //memanggil method getNama didalam class yang sama
        System.out.println(" Jabatan : " + getJB()); //memanggil method getJB didalam class yang sama
        System.out.println(" Gaji : Rp. " + getGaji()); //memanggil method getGaji didalam class yang sama
    }
}
