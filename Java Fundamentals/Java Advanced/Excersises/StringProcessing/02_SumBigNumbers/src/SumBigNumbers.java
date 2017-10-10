import java.util.Scanner;

public class SumBigNumbers {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        String number1 = input.nextLine().replaceFirst("^0+(?!$)", "");
        String number2 = input.nextLine().replaceFirst("^0+(?!$)", "");

        String sum = sumbigNumbers(number1, number2);

        System.out.println(sum);


    }

    private static String sumbigNumbers(String number1, String number2) {


        String sum = "";
        String longernumber = "";
        String shorternumber = "";
        int rem = 0;
        int n = 0;

        if (number1.length() >= number2.length()) {
            longernumber = number1;
            shorternumber = number2;
        } else {
            longernumber = number2;
            shorternumber = number1;
        }

        while (longernumber.length() > 0) {

            if (shorternumber.isEmpty()) {
                n = Integer.parseInt(longernumber.charAt(longernumber.length() -1) + "") + rem;
                longernumber = longernumber.substring(0, longernumber.length() -1);
            } else {
                n = Integer.parseInt(longernumber.charAt(longernumber.length() -1) + "") + Integer.parseInt(shorternumber.charAt(shorternumber.length() -1) + "") + rem;
                longernumber = longernumber.substring(0, longernumber.length() -1);
                shorternumber = shorternumber.substring(0, shorternumber.length() -1);
            }

            rem = 0;
            if (n >= 10) {
                rem = n / 10;
            }
            sum += n % 10;
        }

        StringBuilder sb = new StringBuilder();

        sum = new String (sb.append(sum).reverse());

        if (sum.charAt(0) == '0') {
            sum = "1" + sum;
        }

        return sum;
    }
}
