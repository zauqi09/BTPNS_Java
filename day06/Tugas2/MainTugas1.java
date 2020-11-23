import java.util.*;
//import java.io.*;
public class MainTugas1 {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Staff> staff=new ArrayList<Staff>();
    public static void main(String args[]) {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Buat Object Staff\n2. Tambah Absensi\n3. View Data\n\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            Menu(keyInput);
        } while (keyInput != 0);
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
    public static void Menu(int key){
        switch (key) {
            case 1:
                createStaff();
                pressAnyKeyToContinue();
                break;
            case 2:
                tambahAbsensimain();
                pressAnyKeyToContinue();
                break;
            case 3:
                viewData();
                pressAnyKeyToContinue();
                break;
            default:
                break;
        }
    }
    public static void createStaff(){
        clearScreen();
        System.out.println("Tambah Staff");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Jabatan : ");
            String jabatan = keyboard.nextLine();
            staff.add(new Staff(id, nama, 0, jabatan));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    public static void tambahAbsensimain(){
        clearScreen();
        System.out.println("Tambah Absensi");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < staff.size(); i++)
                {
                    staff.get(i).tambahAbsensi(id);
                }
        } catch (Exception e) {
            System.out.println(e);
        } 
        
    }
    public static void bubbleSort(ArrayList<Staff> list)
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
    public static void viewData(){
        bubbleSort(staff);
        try {
            table show = new table();
            show.setShowVerticalLines(true);
            show.setHeaders("ID","Nama", "Jabatan", "Absensi");
            for (Staff obj: staff) {
                show.addRow(Integer.toString(obj.getIDKaryawan()),obj.getName(),obj.getJabatan(),Integer.toString(obj.getAbsensi()));
            }
            show.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
