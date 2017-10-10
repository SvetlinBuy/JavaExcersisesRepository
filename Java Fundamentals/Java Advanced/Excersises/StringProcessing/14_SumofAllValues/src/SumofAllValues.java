import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumofAllValues {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        String textString = scanner.nextLine();

        Pattern patternStart = Pattern.compile("^[a-zA-Z_]+(?=\\d)");
        Pattern patternEnd = Pattern.compile("(?<=\\d)[a-zA-Z_]+$");

        Matcher matcherStart = patternStart.matcher(keyString);
        Matcher matcherEnd = patternEnd.matcher(keyString);

        String startKey;
        String endKey;

        if (matcherStart.find() && matcherEnd.find()) {
            startKey = matcherStart.group();
            endKey = matcherEnd.group();

            String regex = startKey + "[\\d.]+?" + endKey;
            Pattern digits = Pattern.compile(regex);
            Matcher matchDigits = digits.matcher(textString);
            double sum = 0;

            while (matchDigits.find()) {

                double num = Double.parseDouble(matchDigits.group()
                        .substring(startKey.length(), matchDigits.group().length() - endKey.length()));
                sum += num;
            }

            if (sum > 0) {

                if (sum % 10 == 0) {
                    System.out.printf("<p>The total value is: <em>%f</em></p>", sum);
                }else {
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
                }

            } else {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        }
        else{
            System.out.println("<p>A key is missing</p>");
        }
    }
}
