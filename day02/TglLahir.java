public class TglLahir { //kelas TglLahir
    private int day = 1; //deklarasi + inisialisasi
    private int month = 1; //deklarasi + inisialisasi
    private int year = 1900; //deklarasi + inisialisasi

    public TglLahir(int day, int month, int year){ //konstruktor TglLahir parameter day month year
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear(){ //getYear return year
        return year;
    }
    public String toString() { //method toString
        String monthString; //deklarasi variabel lokal
        switch (month) {
            case 1:  monthString = "Januari"; //case 1 return monthString
                     break;
            case 2:  monthString = "Februari"; //case 2 return monthString
                     break;
            case 3:  monthString = "Maret"; //case 3 return monthString
                     break;
            case 4:  monthString = "April"; //case 4 return monthString
                     break;
            case 5:  monthString = "Mei"; //case 5 return monthString
                     break;
            case 6:  monthString = "Juni"; //case 6 return monthString
                     break;
            case 7:  monthString = "Juli"; //case 7 return monthString
                     break;
            case 8:  monthString = "Agustus"; //case 8 return monthString
                     break;
            case 9:  monthString = "September"; //case 9 return monthString
                     break;
            case 10: monthString = "Oktober"; //case 10 return monthString
                     break;
            case 11: monthString = "November"; //case 11 return monthString
                     break;
            case 12: monthString = "Desember"; //case 12 return monthString
                     break;
            default: monthString = "Invalid month"; //default invalid month
                     break;
        }
        String retString = "" + day + "-" + monthString + "-" + year; //variabel string memanggil day, monthString dan year
        
        return retString; //reaturn retString
    }

    public int Umur(){ //method Umur
        int umur = 2020 - year; //umur di inisialisasikan 2020 dikurangi nilai year
        return umur; //return variabel umur
    }

    public void LoopUmur(int year){ //method LoopUmur dengan paramter year
        String history; //deklarasi lokal variabel history String
        int y =1; //deklarasi y
        for(int i=year; i<2020; i++){ //for i di assign year, selagi i < 2020 i++
            history = ("Tahun "+(i+1) + " ,Umur : " + y+"\n"); //history di assign string
            y++; //y increment
            System.out.print(history); //print history
        }
    }
}
