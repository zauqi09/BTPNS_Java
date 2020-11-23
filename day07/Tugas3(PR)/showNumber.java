import java.util.List;

public class showNumber extends Thread {
    List<Integer> listnumber;
    public showNumber(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
		for (int obj : listnumber) {
            System.out.println(obj);
        }
        
    } 
}