import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListofPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int[] divList = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(m -> Integer.parseInt(m)).toArray();


        for (int i = 1; i <= N; i++) {

            boolean test = true;

            for (int j = 0; j < divList.length; j++) {

                int n = divList[j];

                Predicate<Integer> isDivisible = d -> d % n == 0;

                if (!isDivisible.test(i)) {

                    test = false;
                }

            }

            if (test) {
                System.out.print(i + " ");
            }
        }

    }
}
