import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Latihan3 {
    public static Scanner keyboard = new Scanner(System.in);
    public static String filename;
    public static int jumworker;
    public static List<Integer> listnumber = new ArrayList<Integer>();
    public static void main(String[] args) {
        filename=args[0];
        jumworker=Integer.parseInt(args[1]);
        movetoList();
        menu();
    }
    public static void menu(){
        int keyInput;
        do {
            clearScreen();
            System.out.println("MENU\n1. Print Simple Thread\n2. Print Thread Pool\n3. Thread Print, Thread Read ASC & DESC\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            switch (keyInput) {
                case 1:
                    System.out.println("Simple Thread");
                    clearScreen();
                    simpleThread();
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    System.out.println("Thread Pool");
                    clearScreen();
                    threadPool(jumworker);
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Print ASC DESC");
                    AscThread t1=new AscThread(listnumber);  
                    DescendingThread t2=new DescendingThread(listnumber);
                    showNumber t3=new showNumber(listnumber);
                    t1.start();  
                    t2.start();  
                    t3.start();
                    pressAnyKeyToContinue();
                    break;
                default:
                    break;
            }
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
    public static void threadPool(int jumworker){
        ExecutorService executor = Executors.newFixedThreadPool(jumworker);       
        for (int i: listnumber){
            Runnable worker = new ThreadPool(String.format(""+ i));
            executor.execute(worker);//calling execute method of ExecutorService  
        }
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
 
       System.out.println("Finished all threads");  
    }

    // public static void printascdesc(int jumworker){
    //     ExecutorService executor = Executors.newFixedThreadPool(jumworker);       
    //     for (int i: listnumber){
    //         Runnable worker = new ThreadPool(String.format(""+ i));
    //         executor.execute(worker);//calling execute method of ExecutorService  
    //     }
    //     executor.shutdown();  
    //     while (!executor.isTerminated()) {   }  
 
    //    System.out.println("Finished all threads");  
    // }
    public static void movetoList(){
        String textfile = "";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int i;
            while ((i = br.read()) != -1) {

                textfile += (char) i;
            }
            fr.close();
            br.close();
            String[] values = textfile.split(",");
            for (String obj: values) {
                listnumber.add(Integer.parseInt(obj));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void simpleThread(){
        List<Integer> thread1 = listnumber.subList(0, 25);
        List<Integer> thread2 = listnumber.subList(25, 50);
        List<Integer> thread3 = listnumber.subList(50, 75);
        List<Integer> thread4 = listnumber.subList(75,100);
            
        simpleThread1 t1=new simpleThread1(thread1);
        simpleThread2 t2=new simpleThread2(thread2);  
        simpleThread3 t3=new simpleThread3(thread3);  
        simpleThread4 t4=new simpleThread4(thread4);  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
    }
}
