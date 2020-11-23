public class Luas {
    public static void main(String[] args) {
        switch (args[0]) {
            case "1":
                int sisi = Integer.parseInt(args[1]);
                double luas = Kalkulasi(sisi);
                System.out.println("Luas Persegi : "+luas);
                break;
            case "2":
                double r = Double.parseDouble(args[1]);
                double luaslingkaran = Kalkulasi(r);
                System.out.println("Luas Lingkaran : "+luaslingkaran);
                break;
            case "3":
                double a = Double.parseDouble(args[1]);
                double t = Double.parseDouble(args[2]);
                double luassegitiga = Kalkulasi(a,t);
                System.out.println("Luas Segitiga : "+luassegitiga);
                break;
            case "4":
                int d = Integer.parseInt(args[1]);
                int m = Integer.parseInt(args[2]);
                int y = Integer.parseInt(args[3]);
                double umur = Kalkulasi(d,m,y);
                System.out.println("Umur : "+umur);
                break;
            default:
                break;
        }
        
    }


    //segitiga
    public static double Kalkulasi(double a, double b) {
       double luas;
       luas = (a * b) /2;
       return luas;
    }

    //lingkaran
    public static double Kalkulasi(double r) {
       double luas;
       luas = 3.14 * Math.pow(r,2);
       return luas;
    }

    //persegi
    public static double Kalkulasi(int a) {
       double luas = Math.pow(a,2);
       return luas;
    }

    //menghitung umur
    public static int Kalkulasi(int a, int b, int c) {
        int umur = 2020 - c;
        return umur;
    }
}
