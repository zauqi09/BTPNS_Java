public class TestMyDate {
    public static void main(String[] args) {
        MyDate my_birth = new MyDate(22, 7, 1964);
        my_birth.addYears(7);
        System.out.println(my_birth);
        my_birth.minDays(2);
        System.out.println(my_birth);
        my_birth.minMonths(2);
        System.out.println(my_birth);
        my_birth.addMonths(3);
        System.out.println(my_birth);
    }
}
    