import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Findthesmallestelement {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split("[ ]+");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {

            list.add(Integer.parseInt(s[i]));
        }

        Function<List<Integer>, Integer> findIndexSmallestNumber = f -> {

            int index = 0;
            int smallest = Integer.MAX_VALUE;

            for (int a : f) {

                if (a < smallest) {
                    smallest = a;
                }

                for (int i = 1; i < f.size(); i++) {

                    int b = f.get(i);

                    if (smallest >= b) {
                        index = i;
                    }
                }
            }

            return index;
        };


        System.out.println(findIndexSmallestNumber.apply(list));
    }
}
