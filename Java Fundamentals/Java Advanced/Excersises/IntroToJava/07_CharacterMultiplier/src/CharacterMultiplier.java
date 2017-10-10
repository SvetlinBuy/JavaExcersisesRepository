import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String firstStr = input.next();
        String secondStr = input.next();

        String LongerString = "";
        String ShorterString = "";

        if (firstStr.length() >= secondStr.length()) {

            LongerString = firstStr;
            ShorterString = secondStr;
        } else {

            LongerString = secondStr;
            ShorterString = firstStr;

        }

        int sum = 0;
        for (int i = 0; i <ShorterString.length() ; i++) {

            sum += LongerString.charAt(i) * ShorterString.charAt(i);

        }

        for (int i = ShorterString.length(); i < LongerString.length() ; i++) {
            sum += LongerString.charAt(i);
        }

        System.out.println(sum);

    }
}
