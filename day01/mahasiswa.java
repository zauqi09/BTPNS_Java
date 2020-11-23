class mahasiswa {
     String nama;
     String jeniskelamin;
     int umur;
     public mahasiswa(String newNama, String newJK){
          nama = newNama;
          jeniskelamin = newJK;
     }

     void setNama(String newValue) {
         nama = newValue;
        
     }

     String getNama() {
          return nama;
     }

     void setJK(String newValue) {
          jeniskelamin = newValue;
     }

     String getJK() {
          return jeniskelamin;
     }

     void setUmur(int newValue) {
          umur = newValue;
     }

     int getUmur() {
          return umur;
     }

     void printMahasiswa() {
          System.out.println(" Nama : " + getNama());
          System.out.println(" Jenis Kelamin : " + getJK());
          System.out.println(" Umur : " + getUmur());
     }
}
