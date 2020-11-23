import java.util.*; //import semua yang ada di java.util
public class Latihan3 { //class Latihan3
    static ArrayList<Integer> intgr=new ArrayList<Integer>(); //deklarasi ArrayList bertipedata Integer
    public static void main(String args[]){ //void main
        InputData(); //pemanggilan input data
        printData(intgr); //pemanggilan print data dengan parameter ArrayList
        BubbleSortData(intgr); //pemanggilan sorting data dengan parameter ArrayList
        printData(intgr); //pemanggilan print data dengan parameter ArrayList
        BinnarySearch(intgr, 23); //pemanggilan search data dengan parameter ArrayList
    }



    public static void InputData(){ //method input data
        intgr.add(21); //input 21
        intgr.add(23); //input 23
        intgr.add(26); //input 26
        intgr.add(12); //input 12
        intgr.add(15); //input 15
    }

    public static void printData(ArrayList<Integer> al){ //method printData dengan parameter al bertipe data ArrayList
        for (Integer obj: al) { //for each obj pada variabel al
            System.out.print(obj+", "); //print obj
        }
        System.out.println(); //space
    }

    public static void BubbleSortData(ArrayList<Integer> list){ //method sorting dengan algoritma Bubble Sort paramter list bertipe data ArrayList
        Integer[] a = {}; //deklarasi array a
        a = list.toArray(a); //memindahkan ArrayList ke array integer a
        list.clear(); //membersihkan ArrayList list
        for (int i = 0; i < a.length - 1; i++) { //bubblesort
            for (int j = 0; j < a.length - 1 - i; j++) { //bubblesort
                if (a[j + 1] < a[j]) { //bubblesort
                    int temp = a[j]; //bubblesort
                    a[j] = a[j + 1]; //bubblesort
                    a[j + 1] = temp; //bubblesort
                }
            }
        }
        Collections.addAll(list, a); //menambahkan nilai array a ke list ArrayList
    }

    public static void BinnarySearch(ArrayList<Integer> list,int target){ //BinnarySearch dengan parameter ArrayList list dan int target
        Integer[] a = {}; //deklarasi array a
        a = list.toArray(a); //memindahkan ArrayList ke array integer a
        int left = 0; //binnarysearch
        int middle; //binnarysearch
        int right = a.length - 1; //binnarysearch
        while (left <= right) { //binnarysearch
            middle = (left + right) / 2; //binnarysearch
            if (a[middle] == target) { //binnarysearch
                System.out.println(a[middle] + " found at index " + middle); //binnarysearch
                break; //binnarysearch
            } else if (a[middle] < target) { //binnarysearch
                left = middle + 1; //binnarysearch
            } else if (a[middle] > target) { //binnarysearch
                right = middle - 1; //binnarysearch
                } //binnarysearch
        } //binnarysearch
    }
}
