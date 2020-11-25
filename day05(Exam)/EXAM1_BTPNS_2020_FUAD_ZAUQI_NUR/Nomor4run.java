import java.util.*;

public class Nomor4run {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Nomor4> student=new ArrayList<Nomor4>();
    public static int ID = 1301164001;
    public static void main(String[] args) {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Buat Object Mahasiswa\n2. Edit Data Mahasiswa\n3. Remove Data Mahasiswa\n4. Tampil Data Mahasiswa\n5. Tulis Laporan ke File TXT\n6. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            Menu(keyInput);
        } while (keyInput != 6);
    }

    public static void Menu(int key){
        switch (key) {
            case 1:
                createMahasiswa();
                ID++;
                pressAnyKeyToContinue();
                break;
            case 2:
                editMahasiswa();
                pressAnyKeyToContinue();
                break;
            case 3:
                removeMahasiswa();
                pressAnyKeyToContinue();
                break;
            case 4:
                clearScreen();
                System.out.println("Laporan Mahasiswa");
                laporandataMahasiswa();
                pressAnyKeyToContinue();
                break;
            case 5:
                tulisLaporankeTXT();
                pressAnyKeyToContinue();
                break;
            default:
                break;
        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public static void pressAnyKeyToContinue()
    { 
           System.out.println("Press Enter key to continue...");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }

    public static void createMahasiswa(){
        clearScreen();
        System.out.println("Tambah Mahasiswa");
        try {
            System.out.println("NIM : " +ID);
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Nilai UTS : ");
            int uts = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nilai UAS : ");
            int uas = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nilai Tugas : ");
            int tugas = Integer.parseInt(keyboard.nextLine());
            student.add(new Nomor4(ID, nama, uts,uas,tugas));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public static void editMahasiswa(){
        clearScreen();
        showData();
        System.out.println("\nEdit Mahasiswa");
        try {
            System.out.print("Edit Mahasiswa Nomor : ");
            int no = Integer.parseInt(keyboard.nextLine());
            
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Nilai UTS : ");
            int uts = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nilai UAS : ");
            int uas = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nilai Tugas : ");
            int tugas = Integer.parseInt(keyboard.nextLine());
            student.get(no-1).setNama(nama);
            student.get(no-1).setUTS(uts);
            student.get(no-1).setUTS(uas);
            student.get(no-1).setUTS(tugas);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Sukses!!");
        }
    }

    public static void removeMahasiswa(){
        clearScreen();
        showData();
        System.out.println("\nRemove Mahasiswa");
        try {
            System.out.print("Hapus Mahasiswa nomor : ");
            int no = Integer.parseInt(keyboard.nextLine());
            student.remove(no-1);
            
        } catch (Exception e) {
            System.out.println(e);
        }  
    }
    
    public static void laporandataMahasiswa(){
        try {
            Nomor4table st = new Nomor4table();
            st.setShowVerticalLines(true);
            st.setHeaders("Nama", "UTS", "UAS", "Tugas");
            for (Nomor4 obj: student) {
                st.addRow(obj.getNama(),Integer.toString(obj.getUTS()),Integer.toString(obj.getUAS()),Integer.toString(obj.getTugas()));
            }
            st.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public static void showData(){
        try {
            Nomor4table show = new Nomor4table();
            show.setShowVerticalLines(true);
            show.setHeaders("No","Nama", "UTS", "UAS", "Tugas");
            int i=1;
            for (Nomor4 obj: student) {
                show.addRow(Integer.toString(i),obj.getNama(),Integer.toString(obj.getUTS()),Integer.toString(obj.getUAS()),Integer.toString(obj.getTugas()));
                i++;
            }
            show.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    public static void tulisLaporankeTXT(){
        clearScreen();
        try {
            Nomor4table save = new Nomor4table();
            save.setShowVerticalLines(true);
            save.setHeaders("Nama", "UTS", "UAS", "Tugas");
            for (Nomor4 obj: student) {
                save.addRow(obj.getNama(),Integer.toString(obj.getUTS()),Integer.toString(obj.getUAS()),Integer.toString(obj.getTugas()));
            }
            save.savetofile();
            System.out.println("Sukses!!");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
