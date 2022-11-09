package MyCalculator;

import java.util.Scanner;
import MyCalculator.RomanCalcs; 

public class Main {
    public static void main(String[] args) {
        /**
        Приложение-калькулятор. Реализация - Копысов А.А.

         Калькулятор может выполнять 4 операции: +, -, *, /.
         Принимает на вход как арабские, так и римские цифры, не превышающие 10.
         Числа вводятся в одной системе счисления, результат выражения выводится в той же системе счисления.
         */
        Scanner sc = new Scanner(System.in);
        String introducedString = sc.nextLine();
        int result;


        if (NumberIdentifier.isArabicNumber(introducedString)){
            ArabicCalcs calculation = new ArabicCalcs(introducedString);
            System.out.println(calculation.calculate());

        } else if (NumberIdentifier.isRomanNumber(introducedString)) {
            RomanCalcs calculation = new RomanCalcs(introducedString);
            result = calculation.calculate();
            if (result >= 0){
                System.out.println(calculation.intToRoman(result));
            } else {
                System.out.println("Not positive result of calculations");
            }

        } else {
            System.out.println("Invalid number format");
        }











    }
}
