public class MyExceptions extends Exception {
    private String string;
    public String getString(){return string;}

    public MyExceptions(String message, String input) {
        super(message);
        string = input;
    }
}
