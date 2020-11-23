import java.io.*;
public class FileOutputStreamExample1 {
    public static void main(String args[]){
        try{
            //nulis dari args[]
            FileOutputStream fout=new FileOutputStream(args[0]);
            String t=args[1];
            byte c[]=t.getBytes();//converting string into byte array
            fout.write(c);
            fout.close();

            //baca dari file
            FileInputStream fin=new FileInputStream(args[0]);
            int i=0;
            System.out.print("Isi Text : ");
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
            //System.out.println("success...");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}