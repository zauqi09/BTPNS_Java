import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Latihan1 {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Mahasiswa> student = new ArrayList<Mahasiswa>();
    public static boolean LoggedIn = false;
    public static int ID = 101;
    public static void main(String[] args) {
        do {
            clearScreen();
            System.out.println("LOGIN");
            System.out.print("Username : ");
            String username = keyboard.nextLine();
            System.out.print("Password : ");
            String password = keyboard.nextLine();
            try {
                doLogin(username, password);
                if (LoggedIn) {
                    System.out.println("Berhasil Login");
                    pressAnyKeyToContinue();
                    menu();
                } else {
                    System.out.println("Gagal Login");
                    pressAnyKeyToContinue();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (LoggedIn != true);
    }
    public static void menu(){
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Create & Input Data Mahasiswa\n2. Edit or Delete Data Mahasiswa\n3. Tampilkan laporan Nilai Data Mahasiswa\n\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    createMahasiswa();
                    ID++;
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    do {
                        clearScreen();
                        System.out.println("MENU\n1. Edit Data Mahasiswa\n2. Delete Data Mahasiswa\n\n9. Back to Main Menu\n");
                        System.out.print("Pilih Menu : ");
                        keyInput = Integer.parseInt(keyboard.nextLine());
                        switch (keyInput ) {
                            case 1:
                                clearScreen();
                                editMahasiswa();
                                pressAnyKeyToContinue();
                                break;
                            case 2:
                                clearScreen();
                                removeMahasiswa();
                                pressAnyKeyToContinue();
                                break;
                            default:
                                break;
                        }
                    }while (keyInput != 9);
                    break;      
                case 3:
                    clearScreen();
                    System.out.println("Laporan Mahasiswa");
                    laporandataMahasiswa();
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
    public static void doLogin(String email, String pswd) throws IOException {
        String emailTemp="";
        String pswdTemp="";
        boolean emailCorrect = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).matches();
        boolean pswdCorrect = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$").matcher(pswd).matches();
        if (emailCorrect && pswdCorrect){
            FileReader username=new FileReader("username.txt");
            FileReader password=new FileReader("password.txt");
            BufferedReader uname=new BufferedReader(username);
            BufferedReader pw=new BufferedReader(password);
            int i;
            while((i=uname.read())!=-1){
                emailTemp+=(char)i;
            }
            while((i=pw.read())!=-1){
                pswdTemp+=(char)i;
            }

            if (Pattern.matches(email, emailTemp) && Pattern.matches(pswd, pswdTemp)){
                LoggedIn = true;
            } else {
                System.out.println("Email atau Password salah");
            }
            uname.close();
            pw.close();
            username.close();
            password.close();
        }else {
            System.out.println("Password harus lebih dari 8 character, ada huruf besar dan kecil, memiliki special character");
        }

    }
}
