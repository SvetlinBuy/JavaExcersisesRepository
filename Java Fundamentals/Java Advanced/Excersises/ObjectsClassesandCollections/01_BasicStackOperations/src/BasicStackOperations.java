import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String[] commands = input.nextLine().split(" ");

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < Integer.parseInt(commands[0]); i++) {

            String s = input.next();

            stack.push(s);

        }

        for (int i = 0; i < Integer.parseInt(commands[1]); i++) {

            stack.pop();

        }

        if (stack.contains(commands[2])) {

            System.out.println(true);
        } else {
            if(stack.peek() == null ){
                System.out.println(0);
            }else {
                System.out.println(stack.peek());
            }
        }


    }
}
