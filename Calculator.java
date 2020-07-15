import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt() & in.hasNext() & in.hasNextInt()) {
            int a = in.nextInt();
            check(a);
            String symbol = in.next();
            try {
                int b = Integer.parseInt(in.next());
                check(b);
                System.out.println(a + " " + symbol + " " + b + " = " + arithmetic(a, symbol, b));
            } catch (Exception ex) {
                throw new Exception("Перед числом не должно быть арифметических знаков: '*' и '/' и правильно написано");
            }

        } else if (in.hasNext() & in.hasNext() & in.hasNext()) {
            String a = in.next();
            if (a.contains("+") || a.contains("-") || a.contains("/") || a.contains("*")) {
                throw new Exception("Перед числом не должно быть арифметических знаков: '*' и '/'\n\t Перед римскими числами не должно быть арифметических знаков");
            }
            check(Roman.fromRomanToInt(a));
            String symbol = in.next();
            String b = in.next();
            check(Roman.fromRomanToInt(b));
            System.out.println(a + " " + symbol + " " + b + " = " + Roman.toRomanFromInt(arithmetic(Roman.fromRomanToInt(a), symbol, Roman.fromRomanToInt(b))));

        } else {
            throw new Exception("Используйте только один тип чисел одновременно");
        }
    }

    protected static int arithmetic(int a, String symbol, int b) throws Exception {
        int result;
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

    protected static void check(int number) throws Exception {
            if (number < 1) {
                throw new Exception("Число должно быть больше 1 и правильно написано");
            } else if (number > 10) {
                throw new Exception("Число должно быть меньше 10 и правильно написано");
            }
    }
}
