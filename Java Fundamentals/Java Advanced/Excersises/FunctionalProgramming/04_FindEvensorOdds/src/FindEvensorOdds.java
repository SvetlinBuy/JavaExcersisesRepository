import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FindEvensorOdds {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Function<String, String> fillArray = input -> {

            Predicate<Integer> isEven = number -> number % 2 == 0;
            Consumer<Integer> print = st -> { System.out.print(st + " "); };

            int firstNumber = Integer.parseInt(input.split(" ")[0]);
            int secondNumber = Integer.parseInt(input.split(" ")[1]);
            String numberType = scanner.nextLine();
            String numbers = "";

            if (firstNumber > secondNumber) {

                while (firstNumber >= secondNumber) {isOddEvenChecker(firstNumber, numberType, isEven, print);  firstNumber--;}


            } else {

                while (firstNumber <= secondNumber) {isOddEvenChecker(firstNumber, numberType, isEven, print);   firstNumber++;}

            }

            return numbers;

        };

        fillArray.apply(scanner.nextLine());

    }

    private static void isOddEvenChecker(int firstNumber, String oddEven, Predicate<Integer> isEven, Consumer<Integer> s) {

        if (oddEven.equals("even")) {

            if (isEven.test(firstNumber)) {
                s.accept(firstNumber);
            }

        } else if (oddEven.equals("odd")){

            if (!isEven.test(firstNumber)) {
                s.accept(firstNumber);
            }
        }

    }
}
