public class Number {
    int arabicnumber;
    String romanNumber;
    boolean romulan = false;

    public Number(String q){
        romulan = false;
        /*
        создается объект Number
        если переданная строка есть в массиве символов римских цифр,
        то флаг romulan = true
         */
        for (int i = 0; i<romNumbers.length; i++){
            if (romNumbers[i].equals(q)){
                romulan= true;
            }
        }
        if (romulan==true){
            this.romanNumber = q;
            this.arabicnumber = toArabic(q);
        }else {
            this.arabicnumber = Integer.parseInt(q);
            this.romanNumber = toRom(this.arabicnumber);
        }
    }
    //метод для перевода из арабских цифр в римские
    public String toRom(int a){
        String result = "";
        while (a>=100){
            result +="C";
            a-=100;
        }
        if (a>=90){
            result +="XC";
            a-=90;
        }
        while (a>=50){
            result +="L";
            a-=50;
        }
        if (a>=40){
            result+="XL";
            a-=40;
        }
        while (a>=10){
            result +="X";
            a-=10;
        }
        if (a==9){
            result +="IX";
            a-=9;
        }
        while (a>=5){
            result +="V";
            a-=5;
        }
        if (a==4){
            result +="IV";
            a-=4;
        }
        while (a>0){
            result +="I";
            a-=1;
        }
        return result;
    }

    //метод для перевода из римских цифр в араские
    public int toArabic(String q){
        switch (q){
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return 0;
        }
    }
    static String romNumbers[]={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
}
