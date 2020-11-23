class Mahasiswa {
    int ID;
    String nama;
    String jeniskelamin;

    public Mahasiswa(int newID, String newNama, String newJK){
        ID = newID;
        nama = newNama;
        jeniskelamin = newJK;
    }
    int getID() {
        return ID;
   }

    void setID(int newValue) {
        ID = newValue;
       
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
    public int compareTo(Mahasiswa compareID) {
    
        int compareIDSort = ((Mahasiswa) compareID).getID(); 
        
        //ascending order
        return this.ID - compareIDSort;
        
        //descending order
        //return compareQuantity - this.quantity;
        
    }   

}
