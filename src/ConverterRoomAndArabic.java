import java.util.HashMap;
import java.util.List;

public class ConverterRoomAndArabic {

        public static int toArabic(String string) {
        String romanNumber = string.toUpperCase();
        int result = 0;

        List<RomanNums> romanNums = RomanNums.getReverseSortedValues();
        int i = 0;

        while (romanNumber.length() > 0 && (i < romanNums.size())) {
            RomanNums sym = romanNums.get(i);
            if (romanNumber.startsWith(sym.name())) {
                result += sym.getValue();
                romanNumber = romanNumber.substring(sym.name().length());
            } else {
                i++;
            }
        }
        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException(string + " cannot be converted to a Roman Numeral");
        }
        return result;
    }

    public static String toRoman(int number) {
        if ((number<=0) || (number >= 4000)){
            throw new IllegalArgumentException(number + "is not in range");
        }
        List<RomanNums> romanNums = RomanNums.getReverseSortedValues();
        int i = 0;
        StringBuilder builder = new StringBuilder();

        while ((number>0) && (i < romanNums.size())){
            RomanNums sym = romanNums.get(i);
            if (sym.getValue() <= number){
                builder.append(sym.name());
                number -=sym.getValue();
            }else {
                i++;
            }
        }
        return builder.toString();
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNums> romanNums = RomanNums.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNums.size())) {
            RomanNums currentSymbol = romanNums.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}



