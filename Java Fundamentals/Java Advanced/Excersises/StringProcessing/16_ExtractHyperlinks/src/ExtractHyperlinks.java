import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractHyperlinks {

    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder allText = new StringBuilder();
        Pattern pattern = Pattern.compile("<a\\s+([^>]+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)\"|([^>\\s]*))[^>]*>");

        Matcher matcher = pattern.matcher(compileAllText(allText,read));

        findMatchesAndPrintResult(matcher);
    }

    private static void findMatchesAndPrintResult(Matcher matcher) {
        while (matcher.find()) {
            for (int i = 5; i >= 0; i--) {
                String result = matcher.group(i);
                if (result != null) {
                    System.out.println(result);
                    break;
                }
            }
        }
    }

    private static StringBuilder compileAllText(StringBuilder allText, BufferedReader read) throws IOException {
        while (true) {
            String input = read.readLine();
            if ("END".equals(input)) {
                break;
            }
            allText.append(input);
        }
        return allText;
    }
}
