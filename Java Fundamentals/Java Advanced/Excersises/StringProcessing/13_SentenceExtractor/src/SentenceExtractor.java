import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> result = new ArrayList<>();
        String keyWord = scanner.nextLine();
        String text = scanner.nextLine();

        Pattern regex = Pattern.compile("\\b[A-Z][^!.?]*?\\b\" + keyword + \"\\b[^!.?]*?[.!?]");
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            result.add(matcher.group());
        }
        for (String s : result) {
            System.out.println(s.trim());
        }

    }
}
