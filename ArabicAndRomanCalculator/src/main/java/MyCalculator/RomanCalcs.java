package MyCalculator;

import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Subtraction;

public class RomanCalcs extends Calculations{

    private int variable1;
    private int variable2;
    private String mathOperation;
    private final static int DEFAULT_CASE = -1;
    private String[] parsedString = new String[3];

    public RomanCalcs (String introducedString){
        String[] strParsed = stringParser(introducedString);
        variable1 = translateStrNumToInt(strParsed[0]);
        variable2 = translateStrNumToInt(strParsed[1]);
        mathOperation = strParsed[2];
    }

    @Override
    public int calculate() {
        int result;
        switch (mathOperation){
            case "+":
                result = addition(variable1, variable2);
                break;
            case "-":
                result = subtraction(variable1, variable2);
                break;
            case "*":
                result = multiplication(variable1, variable2);
                break;
            case "/":
                result = division(variable1, variable2);
                break;
            default:
                result = DEFAULT_CASE;

        };
        if (result != DEFAULT_CASE){
            return result;
        } else {
            throw new IllegalArgumentException("Incorrect operation");
        }


    }

    public String[] stringParser(String introducedString){
        if (introducedString.contains("+")){
            parsedString[0] = introducedString.split("\\+")[0];
            parsedString[1] = introducedString.split("\\+")[1];
            parsedString[2] = "+";
        } else if (introducedString.contains("-")) {
            parsedString[0] = introducedString.split("-")[0];
            parsedString[1] = introducedString.split("-")[1];
            parsedString[2] = "-";
        } else if (introducedString.contains("*")) {
            parsedString[0] = introducedString.split("\\*")[0];
            parsedString[1] = introducedString.split("\\*")[1];
            parsedString[2] = "*";
        } else if (introducedString.contains("/")) {
            parsedString[0] = introducedString.split("/")[0];
            parsedString[1] = introducedString.split("/")[1];
            parsedString[2] = "/";
        } else {
            throw new IllegalArgumentException("Illegal Math operation");
        }

        return parsedString;
    }


    @Override
    public int addition(int a, int b) {
        Operation add = new Addition();
        return add.execute(a, b);
    }

    @Override
    public int subtraction(int a, int b) {
        Operation sub = new Subtraction();
        return sub.execute(a, b);
    }

    @Override
    public int multiplication(int a, int b) {
        Operation mult = new Multiplication();
        return mult.execute(a, b);
    }

    @Override
    public int division(int a, int b) {
        Operation div = new Division();
        return div.execute(a, b);
    }



    public int translateStrNumToInt(String numStr) {
        switch (numStr){
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
        }
        throw new IllegalArgumentException("Illegal format of number");
    }

    public String intToRoman(int num) {
        String result = "";
        int units = num%10;
        int decades = num/10;

        if (num == 100){
            result = "C";

        } else {

            String unitsConv = switch (units) {
                case 1 -> "I";
                case 2 -> "II";
                case 3 -> "III";
                case 4 -> "IV";
                case 5 -> "V";
                case 6 -> "VI";
                case 7 -> "VII";
                case 8 -> "VIII";
                case 9 -> "IX";
                default -> "";
            };

            String decadesConv = switch (decades) {
                case 1 -> "X";
                case 2 -> "XX";
                case 3 -> "XXX";
                case 4 -> "XL";
                case 5 -> "L";
                case 6 -> "LX";
                case 7 -> "LXX";
                case 8 -> "LXXX";
                case 9 -> "XC";
                default -> "";
            };

            result = decadesConv + unitsConv;

        }
        return result;
    }


}
