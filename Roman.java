import java.util.Set;
import java.util.EnumSet;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Roman {

    private static int decodeSingleRoman(char letter) {
        switch (letter) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    public static int fromRomanToInt(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase();
        for (int i = 0; i < uRoman.length() - 1; i++) {
            if (decodeSingleRoman(uRoman.charAt(i)) < decodeSingleRoman(uRoman.charAt(i + 1))) {
                result -= decodeSingleRoman(uRoman.charAt(i));
            } else {
                result += decodeSingleRoman(uRoman.charAt(i));
            }
        }
        result += decodeSingleRoman(uRoman.charAt(uRoman.length() - 1));
        return result;
    }


    public enum Numeral {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        public final long weight;

        private static final Set<Numeral> SET = Collections.unmodifiableSet(EnumSet.allOf(Numeral.class));

        Numeral(int weight) {
            this.weight = weight;
        }

        public static Numeral getLargest(long weight) {
            return SET.stream()
                    .filter(numeral -> weight >= numeral.weight)
                    .findFirst()
                    .orElse(I)
                    ;
        }
    };

    public static String toRomanFromInt(int n) {
        return LongStream.iterate(n, l -> l - Numeral.getLargest(l).weight)
                .limit(Numeral.values().length)
                .filter(l -> l > 0)
                .mapToObj(Numeral::getLargest)
                .map(String::valueOf)
                .collect(Collectors.joining())
                ;
    }
//    http://rosettacode.org/wiki/Category:Java Хороший программист должен уметь хорошо искать XD
}
