import java.util.Scanner;
import java.util.function.Predicate;

public class Predicatefornames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split(" ");

        Predicate<String> isValidName = s -> s.length() <= n;

        for (int i = 0; i < names.length; i++) {

            if (isValidName.test(names[i])) {

                System.out.println(names[i]);
            }
        }

    }
}
