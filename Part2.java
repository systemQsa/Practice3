

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    public static void main(String[] args) {
        String input = "When I was younger, so much younger than today\n" +
                    "I never needed anybody's help in any way\n" +
                    "But now these days are gone, I'm not so self-assured\n" +
                    "Now I find I've changed my mind\n" +
                    "I've opened up the doors";
        convert(input);
    }
    public static String convert(String input) {
        StringBuilder part2 = new StringBuilder();
        StringBuilder part02 = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String regexPattern = "(\\b\\w+)(?:\\W+\\1\\b)+";
        String regexPattern2 ="(.)(?=(.*))(?<=(?=\1\1\2$))";
        String lastComma =",([^,]*)$";
        String str;
        Pattern pattern2 = Pattern.compile("(\\w{1,})");
        Matcher matcher2 = pattern2.matcher(input);
        part2.append("Max: ");
        while (matcher2.find()){
          if (matcher2.group().length() == 7){
              part2.append( matcher2.group() + ", ");
          } else if (matcher2.group().length() == 1){
              part02.append(matcher2.group());
          }
        }
       Pattern regex = Pattern.compile(regexPattern);
        str = part2.toString();
        Matcher check = regex.matcher(str);
        while (check.find()){
           str = str.replace(check.group(),check.group(1));
        }
       // System.out.println(str);
        String str2 = part02.toString();
        Pattern regex2 = Pattern.compile("\\b(\\\\w+)(?:\\\\W+\\\\1\\\\b)+");
        Matcher matcher3 = regex2.matcher(str2);
        temp.append( "Min: " + str2.charAt(0) + ", ");
        for (int i = 1;i<str2.length()-1;i++){
            char ch = str2.charAt(i);
            int index = str2.indexOf(ch,i+1);
            if (index == -1){
                if (i == str2.length() - 1){
                    temp.append(ch);
                } else {
                    temp.append(ch + ", ");
                }
            }
        }
       String s = temp.toString();
        String s2 = str.replaceAll(",([^,]*)$","$1");
        String result = s.replaceAll(",([^,]*)$","$1");
        System.out.println(result);
        System.out.println(s2);
        /*
        (.)(?=(.*))(?<=(?=\1.*?\1\2$).+)
        (test)(?=.+\1)
         */
        return null;
    }
}
