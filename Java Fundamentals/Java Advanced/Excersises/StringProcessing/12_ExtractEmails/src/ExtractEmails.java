import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern reg = Pattern.compile(String.format("\\b(?<!\\S)[a-z][a-z0-9\\.\\-_]+[a-z0-9]*@[a-z][a-z\\-]+\\.[a-z][a-z\\.]+[a-z]?\\b"));

        while (!input.equals("end")) {


            Matcher matches = reg.matcher(input);

           while(matches.find()){
               System.out.println(matches.group(0));
           }

            input = scanner.nextLine();
        }
    }
}
