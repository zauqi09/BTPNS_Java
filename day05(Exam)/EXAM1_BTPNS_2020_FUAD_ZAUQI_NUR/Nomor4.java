class Nomor4 {
    int ID;
    String nama;
    int UTS, UAS, Tugas;

    public Nomor4(int ID, String newNama, int UTS, int UAS, int Tugas){
        this.ID = ID;
        nama = newNama;
        this.UTS = UTS;
        this.UAS = UAS;
        this.Tugas = Tugas;
    }

    void setID(int ID){
        this.ID = ID;
    }

    void setNama(String newValue) {
        nama = newValue;
       
    }

    void setUTS(int newValue) {
        UTS=newValue;
       
    }

    void setUAS(int newValue) {
        UAS=newValue;
       
    }
    void setTugas(int newValue) {
        Tugas=newValue;
       
    }
    
    int getID(){
        return ID;
    }

    String getNama() {
         return nama;
    }

    int getUTS(){
        return UTS;
    }
    int getUAS(){
        return UAS;
    }
    int getTugas(){
        return Tugas;
    } 

}
