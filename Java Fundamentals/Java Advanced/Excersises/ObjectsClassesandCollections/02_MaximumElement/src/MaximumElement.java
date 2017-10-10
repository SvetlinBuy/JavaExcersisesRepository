import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();



        for (int i = 0; i < commandsCount; i++) {

            int[] command = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();

            if (command[0] == 1) {

                stack.push(command[1]);

            } else if (command[0] == 2) {

                stack.pop();


            } else if (command[0] == 3) {

                List<Integer> listNumbers = stack.stream().collect(Collectors.toList());

                Collections.sort(listNumbers);

                System.out.println(listNumbers.get(listNumbers.size() -1));
            }

        }

    }
}
