class runMahasiswa {
    public static void main(String[] args) {
    
        mahasiswa mhs = new mahasiswa("Fuad Zauqi Nur","Laki-laki");

        mhs.setUmur(23);
        System.out.println(" Nama : " + mhs.getNama());
        System.out.println(" Jenis Kelamin : " + mhs.getJK());
        System.out.println(" Umur : " + mhs.getUmur());
        
        //perbedaan pakai method
        System.out.println("\n=====using method=====\n");

        mhs.printMahasiswa();
    }

}
