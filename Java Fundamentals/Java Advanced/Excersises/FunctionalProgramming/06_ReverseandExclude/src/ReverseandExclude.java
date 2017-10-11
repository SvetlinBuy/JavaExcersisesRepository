import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReverseandExclude {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<List<Integer>> reverseList= list ->  Collections.reverse(list);
        Consumer<Integer>  print = x -> System.out.print(x + " ");

        String[] numb = scanner.nextLine().split(" ");
        int d = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numb.length; i++) {

            numbers.add(Integer.parseInt(numb[i]));
        }

        reverseList.accept(numbers);

        for (int j = 0; j < numbers.size(); j++) {

            if (!(numbers.get(j) % d == 0)) {
                print.accept(numbers.get(j));
            }
        }
    }
}
