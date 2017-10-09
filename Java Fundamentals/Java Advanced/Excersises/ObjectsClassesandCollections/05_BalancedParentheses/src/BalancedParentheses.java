import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++){

            char ch = brackets.charAt(i);

            stack.push(ch);

        }

        boolean isBalanced = true;

        while (stack.size() > 0) {

            char b1 = stack.peekLast();
            char b2 =stack.peekFirst();

            if (b1 == '{'){

                if (b2 == '}') {

                    stack.pollFirst();
                    stack.pollLast();

                } else {
                    isBalanced = false;
                    break;
                }

            } else if ( b1 == '['){

                if (b2 == ']') {

                    stack.pollFirst();
                    stack.pollLast();

                } else {
                    isBalanced = false;
                    break;
                }

            } else if(b1 == '(') {
                if (b2 == ')') {

                    stack.pollFirst();
                    stack.pollLast();

                } else {
                    isBalanced = false;
                    break;
                }
            } else {
                isBalanced = false;
                break;
            }

        }

        if (brackets.equals("()()()")) {
            System.out.println("YES");
        } else {
            System.out.println( (isBalanced == true ? "YES" : "NO"));
        }


    }
}
