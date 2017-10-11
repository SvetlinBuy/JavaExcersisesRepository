import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] intArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(m -> Integer.parseInt(m)).toArray();

        Function<int[], Integer> findSmallest = a -> {

            int n = Integer.MAX_VALUE;

            for (int i = 0; i < a.length; i++) {

                if (a[i] < n) {

                    n = a[i];
                }
            }

            return n;
        };


        System.out.println(findSmallest.apply(intArr));

    }
}
