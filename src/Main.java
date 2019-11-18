import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Calculator {

    private static final Pattern SIGN = Pattern.compile("[*/+-]");

    public static void main(String[] args) throws Exception {
        int resultArabic = 0;
        String result = new String();
        for (; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                String data = scanner.nextLine();
                Matcher act = SIGN.matcher(data);
                StringBuilder action = new StringBuilder();
                while (act.find()) {
                    action.append(act.group());
                }
                if (action.length() > 1) {
                    throw new MyExceptions("Неверное выражение", String.valueOf(action));
                }

                String numbers[] = data.split(String.format("\\" + action));

                for (int i = 0; i < numbers.length; i++) {
                    if (isRoman(numbers[0].trim()) && isRoman(numbers[1].trim())) {
                        resultArabic = Calculator(ConverterRoomAndArabic.toArabic(numbers[0].trim()), ConverterRoomAndArabic.toArabic(numbers[1].trim()), action.toString());
                        String resultRoman = (ConverterRoomAndArabic.toRoman(resultArabic));
                        result = resultRoman;

                    } else if (isDigit(numbers[0].trim()) && isDigit(numbers[1].trim())) {
                        resultArabic = Calculator(Integer.parseInt(numbers[0].trim()),
                                Integer.parseInt(numbers[1].trim()),
                                action.toString());
                        result = String.valueOf(resultArabic);

                    } else if ((isDigit(numbers[0]) && isRoman(numbers[1])) || (isRoman(numbers[0]) && isDigit(numbers[1])) ||
                            (numbers.length < 2)) {
                        throw new NumberFormatException("Неверное выражение");

                    } else if ((isDigit(numbers[1].trim())) && (Integer.parseInt(numbers[1].trim()) == 0) && (action.equals("/"))) {
                        throw new ArithmeticException("Нельзя делить на ноль");
                    } else {
                        System.err.println("Некорректный ввод");
                        break;
                    }
                }
                System.out.println(result);
            } catch (Exception ex) {
                ex.getMessage();
                ex.printStackTrace();
                break;
            }
        }
    }


    public static boolean isDigit(String string) {
        int number = Integer.parseInt(string);
        return (number >= 0 && number <= 10);
    }

    public static boolean isRoman(String number) {
        HashMap<String, Integer> arabicInteger = new HashMap<>();
        arabicInteger.put("I", 1);
        arabicInteger.put("II", 2);
        arabicInteger.put("III", 3);
        arabicInteger.put("IV", 4);
        arabicInteger.put("V", 5);
        arabicInteger.put("VI", 6);
        arabicInteger.put("VII", 7);
        arabicInteger.put("VIII", 8);
        arabicInteger.put("IX", 9);
        arabicInteger.put("X", 10);
        return (arabicInteger.containsKey(number));
    }
}
