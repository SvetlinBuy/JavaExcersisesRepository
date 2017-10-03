import java.util.Scanner;

public class LettersChangeNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] strings = input.nextLine().split("[ \\t]+");

        double sum =  letterChangeNumbers(0,strings);

        System.out.printf("%.2f",sum);

    }

    private static double letterChangeNumbers(double sum, String[] strings) {


        for (int i = 0; i < strings.length; i++) {

            char firstLetter = strings[i].charAt(0);
            char lastLetter = strings[i].charAt(strings[i].length() - 1);

            double number = Integer.parseInt(strings[i].substring(1,strings[i].length() -1));

            int FirstLetterindex = Character.toUpperCase(firstLetter) - 64;
            int LastLetterindex = Character.toUpperCase(lastLetter) - 64;

            if (firstLetter < 91 )
            {
                number /= FirstLetterindex;

            } else
            {
                number *= FirstLetterindex;
            }

            if (lastLetter < 97)
            {
                number -= LastLetterindex;
            }
            else
            {
                number += LastLetterindex;
            }

            sum += number;

        }

        return sum;
    }
}
