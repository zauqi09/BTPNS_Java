public class Luas2 {
    public static void main(String[] args) {
        switch (args[0]) {
            case "1":
                int sisi = Integer.parseInt(args[1]);
                double volumekubus = Kalkulasi(sisi);
                System.out.println("Volume Persegi : "+volumekubus);
                break;
            case "2":
                double r = Double.parseDouble(args[1]);
                double volumebola = Kalkulasi(r);
                System.out.println("Volume Bola : "+volumebola);
                break;
            case "3":
                printArray(Integer.parseInt(args[1]));
                break;
            default:
                break;
        }
    }
 
     //bola
     public static double Kalkulasi(double r) {
        double vol= (4/3) * 3.14 * Math.pow(r,3);
        return vol;
     }
 
     //kubus
     public static double Kalkulasi(int a) {
        double vol = Math.pow(a,3);
        return vol;
     }
 
     //menghitung umur
     public static void printArray(int a) {
        switch (a) {
            case 2: 
                String[][] arr = {{"satu","dua" , "tiga", "empat"},{ "lima", "enam"}};
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        System.out.println(arr[i][j]);
                    }
                }
                break;
            case 3:
                String[][] arr2 = {{ "satu","dua" , "tiga", "empat", "lima", "enam" },{  "tujuh", "delapan","sembilan" }};
                for (int i = 0; i < arr2.length; i++) {
                    for (int j = 0; j < arr2[i].length; j++) {
                        System.out.println(arr2[i][j]);
                    }
                }
                break;      
            default:
                break;
        }
        
    }
    
}
