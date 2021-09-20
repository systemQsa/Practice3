import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static void main(String[] args) {
       String input ="When I was younger\n" +
               "\n" +
               "I never needed\n";
       //convert(input);
       convert1(input);
    }
    public static String convert(String input) {

        StringBuilder str = new StringBuilder();
        String regex = "(\\w+)";
        String addit = "\\b[a-zA-Z]{3,}";
        String single = "\\b(\\w)";
        String capitalLetter = "[A-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        Pattern eachLetter = Pattern.compile(single);
        Pattern checkLetter = Pattern.compile(capitalLetter);
        Matcher capital;
        Matcher each;
        while (matcher.find()){
           if (matcher.group().length() >= 3){
               each = eachLetter.matcher(matcher.group());
               while(each.find()){
                  if (each.group().equals("W")){
                      each.group().toLowerCase(Locale.ROOT);
                  } else {
                      each.group().toUpperCase(Locale.ROOT);
                  }
               }
           }

        }

        return null;
    }

    public static  String convert1(String input){
        String regex = "^(([A-Z])([a-z]+))\\s([A-Z])\\s(([a-z])([a-z]+))\\s(([a-z])([a-z]+))";
        String regex2 = "([A-Z])\\s(([a-z]{1})([a-z]{4}))\\s(([a-z])([a-z]+))";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(input);

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher m2 = pattern2.matcher(input);

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (m.find()){
            sb.append(m.group(2).toLowerCase(Locale.ROOT) + m.group(3) + " " + m.group(4) + " " + m.group(6).toUpperCase(Locale.ROOT)
            + m.group(7) + " " + m.group(9).toUpperCase(Locale.ROOT) + m.group(10));
        }

        while (m2.find()){
           sb2.append(m2.group(1) + " " + m2.group(3).toUpperCase(Locale.ROOT) +m2.group(4) + " " + m2.group(6).toUpperCase(Locale.ROOT) +
                   m2.group(7));
        }

        sb.append("\n" + sb2);
        System.out.println(sb);
        return null;
    }
}
