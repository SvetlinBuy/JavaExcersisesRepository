import java.util.Scanner;

public class UnicodeCharacters {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String text = input.nextLine();
        String output = EncodeCharactersToUnicode(text);
        System.out.println(output);

    }

    private static String EncodeCharactersToUnicode(String text) {

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
        {
            String encodedValue =String.format("\\u00%x",(int)c);
            sb.append(encodedValue);
        }
        return sb.toString();
    }
}
