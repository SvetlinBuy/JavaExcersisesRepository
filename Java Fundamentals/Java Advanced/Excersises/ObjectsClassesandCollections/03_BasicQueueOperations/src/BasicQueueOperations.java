import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.*;
import java.util.stream.Collectors;

public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       int[] commands = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(m -> Integer.parseInt(m)).toArray();

        Deque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < commands[0]; i++) {

            int number = scanner.nextInt();

            queue.add(number);

        }

        for (int i = 0; i < commands[1]; i++) {

            queue.poll();

        }

        if (queue.contains(commands[2])) {

            System.out.println(true);

        } else {

            if (queue.peek() == null) {
                System.out.println(0);
            } else {

                List<Integer> numbers = queue.stream().collect(Collectors.toList());

                Collections.sort(numbers);


                System.out.println(numbers.get(0));
            }
        }



    }
}
