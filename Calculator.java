import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt() & in.hasNext() & in.hasNextInt()) {
            int a = in.nextInt();
            check(a);
            String symbol = in.next();
            int b = in.nextInt();
            check(b);
            System.out.println(a + " " + symbol + " " + b + " = " + arithmetic(a, symbol, b));
        } else if (in.hasNext() & in.hasNext() & in.hasNext()) {
            String a = in.next();
            check(fromRoman(a));
            String symbol = in.next();
            String b = in.next();
            check(fromRoman(b));
            System.out.println(a + " " + symbol + " " + b + " = " + arithmetic(fromRoman(a), symbol, fromRoman(b)));
        } else {
            throw new Exception("Используйте только один тип чисел одновременно");
        }
    }

    protected static int arithmetic(int a, String symbol, int b) throws Exception {
        int result = 0;
        switch (symbol) {
            case "/": {
                result = a/b;
                break;
            }
            case "*": {
                result = a*b;
                break;
            }
            case "+": {
                result = a+b;
                break;
            }
            case "-": {
                result = a-b;
                break;
            }
            default: {
                throw new Exception("Арифметический знак введен неправильно");
            }
        }
        return result;
    }

    protected static int fromRoman(String roman) {
        int number = 0;
        switch (roman) {
            case "I": {
                number = 1;
                break;
            }
            case "II": {
                number = 2;
                break;
            }
            case "III": {
                number = 3;
                break;
            }
            case "IV": {
                number = 4;
                break;
            }
            case "V": {
                number = 5;
                break;
            }
            case "VI": {
                number = 6;
                break;
            }
            case "VII": {
                number = 7;
                break;
            }
            case "VIII": {
                number = 8;
                break;
            }
            case "IX": {
                number = 9;
                break;
            }
            case "X": {
                number = 10;
                break;
            }
        }
        return number;
    }

    protected static void check(int number) throws Exception {
            if (number < 1) {
                throw new Exception("Число должно быть больше 1 и правильно написано");
            } else if (number > 10) {
                throw new Exception("Число должно быть меньше 10 и правильно написано");
            }
    }
}
