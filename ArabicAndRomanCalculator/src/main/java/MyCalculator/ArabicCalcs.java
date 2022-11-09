package MyCalculator;

import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Subtraction;


public class ArabicCalcs extends Calculations{

    private int variable1;
    private int variable2;
    private String mathOperation;
    private final static int DEFAULT_CASE = -21;
    private String[] parsedString = new String[3];

    public ArabicCalcs (String introducedString){
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
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
        }
        throw new IllegalArgumentException("Illegal format of number");
    }


}
