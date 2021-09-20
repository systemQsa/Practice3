import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    public static void main(String[] args) {
        String input = "This is a test\n" +
                "\n" +
                "And this is also a test \n" +
                "\n" +
                "And these are also tests \n" +
                "\n" +
                "test Это тест \n" +
                "\n" +
                "Это также тест \n" +
                "\n" +
                "И это также тесты";
        convert(input);
    }
    public static String convert(String input) {
        String example = "(\\b\\w+\\b)(?!\\W+\\1\\b)(?=.*\\b\\1\\b)";
        Pattern pat = Pattern.compile(example);
        Matcher match = pat.matcher(input);
        while (match.find()){
            System.out.println(match.group());
        }
        return null;
    }
}
