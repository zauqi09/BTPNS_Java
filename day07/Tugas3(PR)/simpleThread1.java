import java.util.List;

public class simpleThread1 extends Thread {
    List<Integer> listnumber;
    public simpleThread1(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
        for (int obj: listnumber) {
            System.out.println(obj);
        }
    }  
}
