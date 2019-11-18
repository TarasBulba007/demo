public class Calculator {
    int num1, num2;
    String action;

    public Calculator(){

    }

    public static int Calculator(int num1, int num2, String action) {
       int result = 0;
               switch (action) {
            case ("+"):
                result = num1 + num2;
                break;
            case ("-"):
                result = num1 - num2;
                break;
            case ("*"):
                result = num1 * num2;
                break;
            case ("/"):
                result = num1 / num2;
                break;
        }
        return result;
    }

}
