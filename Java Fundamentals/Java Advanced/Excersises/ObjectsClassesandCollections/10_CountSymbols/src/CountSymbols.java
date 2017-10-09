import java.util.*;

public class CountSymbols {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();


        char[] charArr = orderLex(text);

        Map<Character, Integer> charIntArrMap = findOcc(charArr);

        for (Map.Entry<Character, Integer> ch : charIntArrMap.entrySet()) {


            System.out.println(ch.getKey() + ": " + ch.getValue() + " time/s");
        }

    }

    private static Map<Character, Integer> findOcc(char[] charArr) {

        Map<Character, Integer> charIntMap = new TreeMap<>();

        Set<Character> uniqueChars = new TreeSet<>();


        for (int i = 0; i < charArr.length; i++) {

            uniqueChars.add(charArr[i]);

        }
        String unique = "";
        for (char c : uniqueChars) {
            unique += c;
        }
        int[] intArr = new int[uniqueChars.size()];

        for (int j = 0; j < charArr.length; j++) {

            char cArr = charArr[j];

            for (int k = 0; k < uniqueChars.size(); k++) {

                char c = unique.charAt(k);

                if (cArr == c) {

                    intArr[k] += 1;
                }
            }
        }


        for (int i = 0; i < intArr.length; i++) {

            charIntMap.put(unique.charAt(i), intArr[i]);

        }

        int someplace = 0;
        return charIntMap;
    }

    private static char[] orderLex(String text) {

        char[] arr = text.toCharArray();

        Arrays.sort(arr);

        return arr;

    }
}
