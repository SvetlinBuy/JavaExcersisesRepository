import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicExchangeableWords {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] inputArray = input.nextLine().split(" ");

        isExchangable(inputArray);
    }

    private static void isExchangable(String[] inputArray) {

        char[] firstWord = inputArray[0].toCharArray();
        char[] secondWord = inputArray[1].toCharArray();

        Map<Character, Character> exchangable = new LinkedHashMap<>();
        boolean result = true;

        if (firstWord.length == secondWord.length) {
            for (int i = 0; i < firstWord.length; i++) {
                if (exchangable.containsKey(firstWord[i])) {
                    if (exchangable.get(firstWord[i]) != secondWord[i]) {
                        result = false;
                        break;
                    }
                } else {
                    exchangable.put(firstWord[i], secondWord[i]);
                }
            }
        } else {
            result = false;
        }

        System.out.println(result);

    }
}
