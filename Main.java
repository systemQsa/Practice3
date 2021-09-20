import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        File file = new File("C:\\JAVA\\TestingDifferentDtuff\\src\\simple");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }

         */
       String str = "Login;Name;Email\n" +
               "ivanov;Ivan Ivanov;ivanov@mail.com\n" +
               "петров;Петр Петров;petrov@google.com\n" +
               "obama;Barack Obama;obama@google.com\n" +
               "bush;Джордж Буш;bush@mail.com";
       //convert1(str);
        convert2(str);
        // String domains  = convert3(str);
        //System.out.println(domains);
        //convert4(str);
     //([a-zA-Z])+@\w+\.com mail
        //(.+);(.*);[a-zA-Z]+@[a-zA-Z]+\.com all 4 mails see
        //(.+)([a-zA-Zа-яА-Я]):
        //(.+?):(.+?):
        //
    }

    public static String convert1(String input) {
        StringBuilder string = new StringBuilder();
        String str = input.replaceAll(";",": ");
        //System.out.println(str);
        Pattern pattern = Pattern.compile("(.+?):(.+?):(.+@[a-zA-Z]+\\.com)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
           string.append(matcher.group(1) + ": " + matcher.group(3) + "\n");
        }
        //System.out.println(string);
        return null;
    }

    public static String convert2(String input) {
        StringBuilder str = new StringBuilder();
        String newPattern = "(.+);(([a-zA-Z]+|.+)\\s([a-zA-Z]+|.+));([a-z]+@[a-z]+\\.com)";
        String oldPattern = "(.+?);(([a-zA-Zа-яА-ЯёЁєЄіІїЇ]+)\\s([a-zZA-Zа-яА-ЯёЁіІєЄїЇ]+));([a-zA-Z]+@[a-z]+\\.com)";
        Pattern template = Pattern.compile(newPattern);
        Matcher match = template.matcher(input);
        while (match.find()){
            System.out.println(match.group(1));
           // str.append(match.group(4) + " " + match.group(3) + " " + "(email: " + match.group(5) + ")" + System.lineSeparator());

        }
        System.out.print(str);
        return null;
    }

    public static String convert3(String input) {
        String domainMail = "mail.com ==> ";
        String domainGoogle = "google.com ==> ";
        StringBuilder mail = new StringBuilder();
        StringBuilder google = new StringBuilder();
        mail.append(domainMail);
        google.append(domainGoogle);
        Pattern pat = Pattern.compile("(.+?);(.+?);.+?(?<=@)(.+)(\\.com)");
        Matcher mat = pat.matcher(input);
        while (mat.find()){
            if (mat.group(3).equals("mail")){
                mail.append(mat.group(1) + ",");
            } else if(mat.group(3).equals("google")){
                google.append(mat.group(1) + ",");
            }
        }

        return mail + System.lineSeparator() + google ;
    }

    public static String convert4(String input) {
        StringBuilder build = new StringBuilder();
        Pattern pattern4 = Pattern.compile("(.+);(.+);([a-zA-Z]+@.+\\.com)");
        Matcher matcher4 = pattern4.matcher(input);
        int max = 9999;
        int min = 1000;
        Random rand = new Random();
        build.append("Login;Name;Email;Password\n");
        while(matcher4.find()){
            int pass = min + (int)(Math.random() *((max  - min )+ 1));
            build.append(matcher4.group(1) + ";" + matcher4.group(2) +";" + matcher4.group(3) + ";" + pass +"\n");
        }
        System.out.print(build);
        return null;
    }
}
