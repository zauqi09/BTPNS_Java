import java.util.*;
//import java.io.*;
public class MainTugas1 {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Staff> staff=new ArrayList<Staff>();
    public static ArrayList<Manager> manager=new ArrayList<Manager>();
    public static void main(String args[]) {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Tambah Manager atau Staff\n2. Absensi Worker\n3. Hitung Tunjangan\n4. Hitung Total Gaji\n5. Cetak Laporan Gaji\n\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            Menu(keyInput);
        } while (keyInput != 0);
    }
    //clrscrn
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    //press enter to continue
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
    //Menu
    public static void Menu(int key){
        switch (key) {
            case 1:
                SubMenu1();
                break;
            case 2:
                SubMenu2();
                break;
            case 3:
                SubMenu3();
                break;
            case 4:
                SubMenu4();
                break;
            case 5:
                viewData();
                pressAnyKeyToContinue();
                break;
            default:
                break;
        }
    }
    //submenu1
    public static void SubMenu1(){
        int keyInput;
                do {
                    clearScreen();
                    //submenu
                    System.out.println("SUBMENU\n1. Tambah Manager\n2. Tambah Staff\n\n9. Back to Main Menu\n");
                    System.out.print("Pilih Menu : ");
                    keyInput = Integer.parseInt(keyboard.nextLine());
                    switch (keyInput) {
                        case 1:
                            createManager();
                            pressAnyKeyToContinue();
                            break;
                        case 2:
                            createStaff();
                            pressAnyKeyToContinue();
                            break;
                        default:
                            break;
                    }                      
                } while (keyInput != 9);
                
    }
    //submenu2
    public static void SubMenu2(){
        int keyInput;
                do {
                    clearScreen();
                    //submenu
                    System.out.println("SUBMENU\n1. Tambah Absensi Manager\n2. Tambah Absensi Staff\n\n9. Back to Main Menu\n");
                    System.out.print("Pilih Menu : ");
                    keyInput = Integer.parseInt(keyboard.nextLine());
                    switch (keyInput) {
                        case 1:
                            tambahAbsensimanager();
                            pressAnyKeyToContinue();
                            break;
                        case 2:
                            tambahAbsensistaff();
                            pressAnyKeyToContinue();
                            break;
                        default:
                            break;
                    }                      
                } while (keyInput != 9);
                
    }
    //submenu3
    public static void SubMenu3(){
        int keyInput;
                do {
                    clearScreen();
                    //submenu
                    System.out.println("SUBMENU\n1. Hitung Tunjangan Manager\n2. Hitung Tunjangan Staff\n\n9. Back to Main Menu\n");
                    System.out.print("Pilih Menu : ");
                    keyInput = Integer.parseInt(keyboard.nextLine());
                    switch (keyInput) {
                        case 1:
                            HitungTJManager();
                            pressAnyKeyToContinue();
                            break;
                        case 2:
                            HitungTJStaff();
                            pressAnyKeyToContinue();
                            break;
                        default:
                            break;
                    }                      
                } while (keyInput != 9);
                
    }
    //submenu4
    public static void SubMenu4(){
        int keyInput;
                do {
                    clearScreen();
                    //submenu
                    System.out.println("SUBMENU\n1. Hitung Total Gaji Manager\n2. Hitung Total Gaji Staff\n\n9. Back to Main Menu\n");
                    System.out.print("Pilih Menu : ");
                    keyInput = Integer.parseInt(keyboard.nextLine());
                    switch (keyInput) {
                        case 1:
                            HitungTGManager();
                            pressAnyKeyToContinue();
                            break;
                        case 2:
                            HitungTGStaff();
                            pressAnyKeyToContinue();
                            break;
                        default:
                            break;
                    }                      
                } while (keyInput != 9);
                
    }

    //create staff
    public static void createStaff(){
        clearScreen();
        System.out.println("Tambah Staff");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            staff.add(new Staff(id, nama));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    //create manager
    public static void createManager(){
        clearScreen();
        System.out.println("Tambah Manager");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            manager.add(new Manager(id, nama));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    //tambah absensi staff
    public static void tambahAbsensistaff(){
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
    //tambah absensi manager
    public static void tambahAbsensimanager(){
        clearScreen();
        System.out.println("Tambah Absensi");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < manager.size(); i++)
                {
                    manager.get(i).tambahAbsensi(id);
                }
        } catch (Exception e) {
            System.out.println(e);
        } 
        
    }

    //hitung tunjangan staff
    public static void HitungTJStaff(){
        clearScreen();
        System.out.println("Hitung tunjangan Staff");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < staff.size(); i++)
                {
                    staff.get(i).HitungTJmakan(id);
                }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    //hitung tunjuangan manager
    public static void HitungTJManager(){
        clearScreen();
        System.out.println("Hitung tunjangan Manager");
        try {
            System.out.print("Masukan ID : ");
            int id = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan jumlah Entertaint : ");
            int ent = Integer.parseInt(keyboard.nextLine());
            for (int i = 0; i < manager.size(); i++)
                {
                    manager.get(i).HitungTJTransport(id);
                    manager.get(i).HitungTJEntertaint(id,ent);
                }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    //hitung total gaji manager
    public static void HitungTGManager(){
        clearScreen();
        System.out.println("Hitung Total Gaji Manager");
        try {
            for (int i = 0; i < manager.size(); i++)
                {
                    for (Manager obj: manager){
                        System.out.println("Sedang menghitung gaji karyawan dengan ID : "+obj.getIDKaryawan());
                        manager.get(i).hitungGajiTotal(obj.getIDKaryawan());
                    }
                }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    //hitung total gaji staff
    public static void HitungTGStaff(){
        clearScreen();
        System.out.println("Hitung Total Gaji Staff");
        try {
            for (int i = 0; i < staff.size(); i++)
                {
                    for (Staff obj: staff){
                        System.out.println("Sedang menghitung gaji karyawan dengan ID : "+obj.getIDKaryawan());
                        staff.get(i).hitungGajiTotal(obj.getIDKaryawan());
                    }
                }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    //bubblesort manager
    public static void bubbleSortManager(ArrayList<Manager> list)
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

    //bubblesort staff
    public static void bubbleSortStaff(ArrayList<Staff> list)
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
        try {
            table show = new table();
            show.setShowVerticalLines(true);
            show.setHeaders("ID","Nama", "Jabatan", "Gaji Total");
            bubbleSortManager(manager);
            bubbleSortStaff(staff);
            for (Manager obj: manager) {
                show.addRow(Integer.toString(obj.getIDKaryawan()),obj.getName(),obj.getJabatan(),Integer.toString(obj.getGajiTotal()));
            }
            for (Staff obj: staff) {
                show.addRow(Integer.toString(obj.getIDKaryawan()),obj.getName(),obj.getJabatan(),Integer.toString(obj.getGajiTotal()));
            }
            show.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
