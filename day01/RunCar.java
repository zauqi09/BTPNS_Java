class RunCar {
    public static void main(String[] args) {
    
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setMerk("Mobil Butut");
        car1.setWarna("Merah Putih Kuning");
        car1.tambahGigi();
        car1.tambahGigi();
        car1.tambahGigi();
        car1.Ngerem(50);
        car1.tambahGigi();
        car1.kurangGigi();
        car1.printStates();

        car2.setMerk("Avanza");
        car2.setWarna("Putih");
        car2.tambahGigi();
        car2.tambahGigi();
        car2.tambahGigi();
        car2.tambahGigi();
        car2.kurangGigi();
        car2.printStates();
    }

}
