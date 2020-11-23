import java.util.*;
import java.io.*;
public class runMahasiswa {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Mahasiswa> student=new ArrayList<Mahasiswa>();
    public static void main(String[] args) {
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Buat Object Mahasiswa\n2. Edit Data Mahasiswa\n3. Remove Object Mahasiswa\n4. Laporan Data Mahasiswa\n5. Tulis Laporan ke File TXT\n6. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            Menu(keyInput);
        } while (keyInput != 6);
    }

    public static void Menu(int key){
        switch (key) {
            case 1:
                createMahasiswa();
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
            System.out.print("Masukan NIM : ");
            int nim = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Gender : ");
            String gender = keyboard.nextLine();
            student.add(new Mahasiswa(nim, nama, gender));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public static void editMahasiswa(){
        clearScreen();
        laporandataMahasiswa();
        System.out.println("================");
        System.out.println("Edit Mahasiswa");
        try {
            System.out.print("Edit Index Ke? : ");
            int index = Integer.parseInt(keyboard.nextLine());
            
            System.out.print("Masukan NIM : ");
            int nim = Integer.parseInt(keyboard.nextLine());
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Gender : ");
            String gender = keyboard.nextLine();
            student.get(index-1).setID(nim);
            student.get(index-1).setNama(nama);
            student.get(index-1).setJK(gender);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Sukses!!");
        }
    }

    public static void removeMahasiswa(){
        clearScreen();
        laporandataMahasiswa();
        System.out.println("================");
        System.out.println("Remove Mahasiswa");
        try {
            System.out.print("Hapus Mahasiswa index ke : ");
            int index = Integer.parseInt(keyboard.nextLine());
            student.remove(index-1);
            
        } catch (Exception e) {
            System.out.println(e);
        }  
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
        bubbleSort(student);
        try {
            int i=1;
            for (Mahasiswa obj: student) {
                System.out.println("No : "+i+"\nID : "+obj.getID()+"\nNama : "+obj.getNama()+"\nJenis Kelamin : "+obj.getJK()+"\n\n");
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    public static void tulisLaporankeTXT(){
        clearScreen();
        try {
            FileWriter writer=new FileWriter("Mahasiswa.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            for (Mahasiswa obj: student) {
                buffer.write("ID : "+obj.getID()+"\nNama : "+obj.getNama()+"\nJenis Kelamin : "+obj.getJK()+"\n\n");
            }
            buffer.close();
            System.out.println("Sukses!!");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
