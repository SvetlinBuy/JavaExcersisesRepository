import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String[] bannedWords = input.nextLine().split(", ");

        String textToFilter = input.nextLine();

        textToFilter  = textToFilter(textToFilter, bannedWords);

        System.out.println(textToFilter);

    }

    private static String textToFilter(String textToFilter, String[] bannedWords) {


        for (int i = 0; i < bannedWords.length; i++) {

            Pattern pattern = Pattern.compile(String.format("%s+",bannedWords[i]), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(textToFilter);

            String str = new String(new char[bannedWords[i].length()]).replace("\0", "*");

            while (matcher.find()) {

              textToFilter = matcher.replaceAll(str);

            }
        }

        return textToFilter;
    }


}
