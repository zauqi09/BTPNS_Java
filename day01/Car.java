class Car {
     String merk = "Honda Jazz";
     String warna ="Putih";
     int speed = 0;
     int gear = 0;

     void setMerk(String newValue) {
          merk = newValue;
          System.out.println("Merknya jadi : " +newValue);
     }

     void setWarna(String newValue) {
          warna = newValue;
          System.out.println("Warnanya jadi : " +newValue);
     }

     void tambahGigi(){
          gear = gear + 1;
          speed = speed +50;
          System.out.println("Tambah Gigi bos, Gigi : "+gear + ",speed : "+speed);
     }
     void kurangGigi(){
          gear = gear - 1;
          speed = speed -50;
          System.out.println("Kurang Gigi bos, Gigi : "+gear + ",speed : "+speed);
     }


    void Ngerem(int decrement) {
         speed = speed - decrement;
         System.out.println("Ngerem ah, speednya jadi : "+speed);
    }

    void printStates() {
         System.out.println(" Final Mobil " +
             merk + "warna" + warna + " speed:" + 
             speed + " gear:" + gear);
    }
}
