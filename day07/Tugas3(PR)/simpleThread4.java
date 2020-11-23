import java.util.List;

public class simpleThread4 extends Thread {
    List<Integer> listnumber;
    public simpleThread4(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
        for (int obj: listnumber) {
            System.out.println(obj);
        }
    }  
}