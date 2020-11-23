import java.util.*;

public class Latihan2{
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Mahasiswa> student = new ArrayList<Mahasiswa>();
    public static boolean LoggedIn = false;
    public static int ID = 101;
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Create & Input Data Mahasiswa\n2. Tampilkan laporan Nilai Data Mahasiswa\n3. Tampilkan sekaligus Simpan laporan Nilai Data Mahasiswa(Multi Threading)\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    createMahasiswa();
                    ID++;
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Laporan Mahasiswa");
                    laporandataMahasiswa();
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Laporan Mahasiswa");
                    printLayar t1=new printLayar(student);  
                    savetofile t2=new savetofile(student);  
                    t1.start();  
                    t2.start();  
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
        } while (keyInput != 0);
    }

    public static void createMahasiswa(){
        clearScreen();
        System.out.println("Tambah Mahasiswa");
        try {
            System.out.println("NIM : " +ID);
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Nilai Bahasa Inggris: ");
            Double bing = Double.parseDouble(keyboard.nextLine());
            System.out.print("Masukan Nilai Fisika : ");
            Double fis = Double.parseDouble(keyboard.nextLine());
            System.out.print("Masukan Nilai Algoritma : ");
            Double alg = Double.parseDouble(keyboard.nextLine());
            student.add(new Mahasiswa(ID, nama,bing,fis,alg));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    public static void editMahasiswa(){
        clearScreen();
        System.out.println("\nEdit Mahasiswa");
        try {
            System.out.print("Masukan NIM : ");
            int id = Integer.parseInt(keyboard.nextLine());
            int index;
            Comparator<Mahasiswa> c = new Comparator<Mahasiswa>() 
            { 
                public int compare(Mahasiswa u1, Mahasiswa u2) 
                { 
                    return u1.getID().compareTo(u2.getID()); 
                } 
            }; 
            index = Collections.binarySearch(student, new Mahasiswa(id, null,null,null,null), c);
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine(); 
			student.get(index).setNama(nama);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Sukses!!");
        }
    }
    public static void removeMahasiswa(){
        clearScreen();
        System.out.println("\nRemove Mahasiswa");
        try {
            System.out.print("Masukan NIM : ");
            int id = Integer.parseInt(keyboard.nextLine());
            int index;
            Comparator<Mahasiswa> c = new Comparator<Mahasiswa>() 
            { 
                public int compare(Mahasiswa u1, Mahasiswa u2) 
                { 
                    return u1.getID().compareTo(u2.getID()); 
                } 
            }; 
            index = Collections.binarySearch(student, new Mahasiswa(id, null,null,null,null), c);
			student.remove(index);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Sukses!!");
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
    public static void bubbleSort(ArrayList<Mahasiswa> list)
    {
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.size() - 1; j++)
            {
                if (list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Collections.swap(list, j, j + 1);
                }
            }
    }
    public static void laporandataMahasiswa(){
        try {
            table show = new table();
            show.setShowVerticalLines(true);
            show.setHeaders("ID","Nama", "Bahasa Inggris", "Fisika", "Algoritma");
            bubbleSort(student);
            for (Mahasiswa obj: student) {
                show.addRow(Integer.toString(obj.getID()),obj.getNama(),Double.toString(obj.getNilai().get(0)),Double.toString(obj.getNilai().get(1)),Double.toString(obj.getNilai().get(2)));
            }
            show.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
     public static void tulisLaporankeTXT(){
        clearScreen();
        try {
            table show = new table();
            show.setShowVerticalLines(true);
            show.setHeaders("ID","Nama", "Bahasa Inggris", "Fisika", "Algoritma");
            bubbleSort(student);
            for (Mahasiswa obj: student) {
                show.addRow(Integer.toString(obj.getID()),obj.getNama(),Double.toString(obj.getNilai().get(0)),Double.toString(obj.getNilai().get(1)),Double.toString(obj.getNilai().get(2)));
            }
            show.savetofile();
        } catch (Exception e) {
            System.out.println(e);
        } 
        
    }
}
