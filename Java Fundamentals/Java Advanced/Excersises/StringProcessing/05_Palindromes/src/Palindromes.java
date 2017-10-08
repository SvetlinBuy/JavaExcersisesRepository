
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindromes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        Pattern pattern = Pattern.compile(String.format("([^!?., ]+)"));
        Matcher matcher = pattern.matcher(text);

        Set<String> palindormes = new TreeSet<>();

        while(matcher.find()){

            int countMatches = matcher.groupCount();

            for (int i = 0; i < countMatches; i++) {

                String word = matcher.group(i);

                if(word.length() % 2 == 0) {

                    if (checkifPallindromeEven(word)){

                        palindormes.add(word);

                    }
                }else {

                    if (checkifPallindromeOdd(word)) {

                        palindormes.add(word);

                    }
                }
            }
        }

        System.out.println(palindormes);

    }

    private static boolean checkifPallindromeOdd(String word) {


        String wordTrim = word.substring(0, word.length() /2);
        StringBuilder sb = new StringBuilder();

        sb.append(word);

        String revWord = sb.reverse().substring(0, word.length() / 2 );

        int count = 0;

        for (int i = 0; i < revWord.length(); i++) {

            if(word.charAt(i) == revWord.charAt(i)){
                count++;
            }
        }

        if (count == word.length() /2)  {

            return  true;

        } else {
            return false;
        }
    }

    private static boolean checkifPallindromeEven(String word) {


        StringBuilder sb = new StringBuilder();

        sb.append(word);

        String revWord = sb.reverse().toString();

        int count = 0;

        for (int i = 0; i < word.length() / 2; i++) {



            if(word.charAt(i) == revWord.charAt(i)){

                count++;

            }

        }

        if (count == word.length() /2 ) {

            return  true;

        } else {
            return false;
        }

    }
}
