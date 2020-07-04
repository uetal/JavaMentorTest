import java.io.IOException;

public class Calculator {
    public static void Calc(String s)throws IOException {
        /*
        Определяем знак вычисления и от него отталкиваемся в нахождении чисел в строке
        для этого введенную строку переводим в массив символов
         */
        char array[]  = s.toCharArray();
        String numS1;
        String numS2;
        char Sign = 0;
        int count = 0;
        for (int x =0; x<array.length;x++){
            if (array[x]=='+'||array[x]=='-'||array[x]=='*'||array[x]=='/'){
                Sign=array[x];
                count =x;
            }
        }
        numS1 = s.substring(0,count).trim();
        numS2 = s.substring(count+1).trim();
        /*
        определение соответствия 7 условия
         */
        if (Sign==0){
            throw new IOException("Не соответствует арифметической операции");
        }
        Number number1 = new Number(numS1);
        Number number2 = new Number(numS2);
        /*
        Определение 5 условия
         */
        if (!number1.romulan==number2.romulan){
            throw new IOException("Не соответствует 5 условию");
        }
        Number result = Arithmetic(number1,Sign,number2);
        if (number1.romulan==true){
            System.out.println(result.romanNumber);
        }else {
            System.out.println(result.arabicnumber);
        }
    }

    public static Number Arithmetic(Number a, char b, Number c) throws IOException {
        if (a.arabicnumber>10||c.arabicnumber>10){
            throw new NumberFormatException("введенное число больше 10");
        }
        String q = "";
        int result = 0;
        String bs = Character.toString(b);
        if (bs.equals("+")){
            result=a.arabicnumber+c.arabicnumber;
        }
        if (bs.equals("-")){
            result=a.arabicnumber-c.arabicnumber;
        }
        if (bs.equals("*")){
            result=a.arabicnumber*c.arabicnumber;
        }
        if (bs.equals("/")){
            result=a.arabicnumber/c.arabicnumber;
        }
        q = q+result;
        return new Number(q);
    }
}
