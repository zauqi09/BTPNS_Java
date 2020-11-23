import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AscThread extends Thread {
    List<Integer> listnumber;
    public AscThread(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
		try {
            FileWriter writer = new FileWriter("fileDataAsc.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            bubbleSortASC(listnumber);
            for (int obj: listnumber) {
                buffer.write(Integer.toString(obj));
                buffer.write("\n");
            }
            buffer.close();
            writer.close();
        System.out.println("Sorted Ascending Done!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    } 
    public static void bubbleSortASC(List<Integer> list)
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