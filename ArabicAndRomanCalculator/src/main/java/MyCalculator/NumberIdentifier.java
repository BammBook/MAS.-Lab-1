package MyCalculator;

public class NumberIdentifier {

    public static boolean isRomanNumber (String introducedString){
        String variable = String.valueOf(introducedString.charAt(0));

        boolean isRoman = true;

        switch (variable){
            case "I":
            case "V":
            case "X":
                break;
            default:
                isRoman = false;
                break;
        }
        return isRoman;
    }

    public static boolean isArabicNumber (String introducedString){
            String variable = String.valueOf(introducedString.charAt(0));

        boolean isArabic = true;

        switch (variable){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                break;
            default:
                isArabic = false;
                break;
        }
        return isArabic;
    }



}
