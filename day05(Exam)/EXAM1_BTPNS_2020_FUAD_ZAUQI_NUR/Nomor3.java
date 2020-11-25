import java.util.*;
public class Nomor3 {
    public static Scanner keyboard = new Scanner(System.in);
    public static double volumekubus,volumebalok,volumebola,summary,avg;
    public static void main(String[] args) {   
        int keyInput;
        do {
            System.out.println("MENU\n1. Volume Kubus\n2. Volume Bola\n3. Volume Balok\n4. Average\n5. Summary\n6. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            Menu(keyInput);
        } while (keyInput != 6);
    }

    public static void Menu(int input){
        switch (input) {
            case 1:
                System.out.print("Masukan Sisi : ");
                int sisi = Integer.parseInt(keyboard.nextLine());
                volumekubus = Kalkulasi(sisi);
                System.out.println("Volume Kubus : "+volumekubus);
                break;
            case 2:
                System.out.print("Masukan Radius : ");
                double r = Double.parseDouble(keyboard.nextLine());
                volumebola = Kalkulasi(r);
                System.out.println("Volume Bola : "+volumebola);
                break;
            case 3:
                System.out.print("Masukan Panjang : ");
                int p = Integer.parseInt(keyboard.nextLine());
                System.out.print("Masukan Lebar : ");
                int l = Integer.parseInt(keyboard.nextLine());
                System.out.print("Masukan Tinggi : ");
                int t = Integer.parseInt(keyboard.nextLine());
                volumebalok = Kalkulasi(p,l,t);
                System.out.println("Volume Balok : "+volumebalok);
                break;
            case 4:
                System.out.println("Volume Kubus : "+volumekubus);
                System.out.println("Volume Bola : "+volumebola);
                System.out.println("Volume Balok : "+volumebalok);
                avg = AVG(volumekubus,volumebalok,volumebola);
                System.out.println("Average : "+avg);
                break;
            case 5:
                System.out.println("Volume Kubus : "+volumekubus);
                System.out.println("Volume Bola : "+volumebola);
                System.out.println("Volume Balok : "+volumebalok);
                summary = Summary(volumekubus,volumebalok,volumebola);
                System.out.println("Summary : "+summary);
            default:
                break;
        }
    }
    
    //balok
    public static double Kalkulasi(int p, int l, int t) {
        double vol= p*l*t;
        return vol;
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

    public static double Summary(double kubus, double balok, double bola) {
        double summary = kubus+balok+bola;
        return summary;
    }

    public static double AVG(double kubus, double balok, double bola) {
        double avg = (kubus+balok+bola)/3;
        return avg;
    }
}
