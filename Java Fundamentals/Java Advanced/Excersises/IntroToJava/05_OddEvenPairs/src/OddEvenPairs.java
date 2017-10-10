import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class OddEvenPairs {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] arrStr = input.nextLine().split(" ");



        if (arrStr.length % 2 == 1 ) {
            System.out.println("invalid length");
        } else {

            for (int i = 0; i < arrStr.length ; i+=2) {

                int firstPair = Integer.parseInt(arrStr[i]);
                int secondPair = Integer.parseInt(arrStr[i+1]);

                String firstPairType = "odd";
                String secondPairType = "odd";

                if (firstPair % 2 == 0) {
                    firstPairType = "even";
                }

                if (secondPair % 2 == 0) {
                    secondPairType = "even";
                }

                if (!firstPairType.equals(secondPairType)) {
                    System.out.printf("%d, %d -> different%n", firstPair, secondPair);
                }else {

                    if ( firstPair % 2 == 0  ){
                        System.out.printf("%d, %d -> both are even%n", firstPair, secondPair);
                    }else {
                        System.out.printf("%d, %d -> both are odd%n", firstPair, secondPair);
                    }
                }

            }

        }
    }
}
