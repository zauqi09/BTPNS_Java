public class MyDate {
    private int day = 1;
    private int month = 1;
    private int year = 2000;
    	
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
         }
    
    public MyDate(MyDate date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }
    public void setDay(int day) {
        this.day = day;
         }
    
    public MyDate addDays(int moreDays) {
        MyDate newDate = new MyDate(this);
        newDate.day = newDate.day + moreDays;
        // Not Yet Implemented: wrap around code...
        return newDate;
        }
    public void addMonths(int moreMonths) {
        this.month = this.month + moreMonths;
        // Not Yet Implemented: wrap around code...
        }
    public void addYears(int moreYears) {
        this.year = this.year + moreYears;
        // Not Yet Implemented: wrap around code...
        }
    public void minDays(int minYears) {
        this.day = this.day - minYears;
        // Not Yet Implemented: wrap around code...
        }
    public void minMonths(int minMonths) {
        this.month = this.month - minMonths;
        // Not Yet Implemented: wrap around code...
        }
    
        
        public String toString() {
            String retString = "" + day + "-" + month + "-" + year;
            return retString;
        }
    }
        
    
