import java.util.*;
public class printLayar extends Thread{
    public static ArrayList<Mahasiswa> student;
    public printLayar(ArrayList<Mahasiswa> list){
        student=list; 
    }
    public void run(){  
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
}
