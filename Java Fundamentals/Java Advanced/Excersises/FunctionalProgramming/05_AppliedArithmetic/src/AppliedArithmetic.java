import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class AppliedArithmetic {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        long[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(m -> Long.parseLong(m)).toArray();

        Consumer<Long>  print = x -> System.out.print(x + " ");

        String operations = scanner.nextLine();

        while (!operations.equals("end")) {

            for (int  i = 0; i < numbers.length; i++) {

                switch (operations) {

                    case "add": numbers[i]+=1;;break;
                    case "multiply":numbers[i]*=2; break;
                    case "subtract":numbers[i]-=1; break;
                    case "print": print.accept(numbers[i]);break;
                }
            }

            operations = scanner.nextLine();
        }
    }
}
