import java.util.*;
import java.io.*;
public class runMahasiswaOld {
    public static void main(String[] args) {
        try{
            ArrayList<Mahasiswa> student=new ArrayList<Mahasiswa>();

            //write Mahasiswa.txt
            FileOutputStream fr=new FileOutputStream("Mahasiswa.txt");
            BufferedOutputStream br=new BufferedOutputStream(fr);
            
            //make object
            student.add(new Mahasiswa(1301164392, "Fuad Zauqi Nur", "Laki-laki"));
            student.add(new Mahasiswa(1301164394, "Samsul Bahri", "Laki-laki"));
            student.add(new Mahasiswa(1301164405, "Siti Fatmala Sari", "Perempuan"));
            //write with foreach
            for (Mahasiswa obj: student) {
                String s="ID : "+obj.getID()+"\nNama : "+obj.getNama()+"\nJenis Kelamin : "+obj.getJK()+"\n\n";
                byte b[]=s.getBytes();
                br.write(b);
            }
            br.flush();
            br.close();
            fr.close();

            
            //print Mahasiswa.txt
            FileInputStream writer=new FileInputStream("Mahasiswa.txt");
            BufferedInputStream buffer = new BufferedInputStream(writer);
            int i;
            //print char with while
            while((i=buffer.read())!=-1){
                System.out.print((char)i);
            }
            buffer.close();
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
