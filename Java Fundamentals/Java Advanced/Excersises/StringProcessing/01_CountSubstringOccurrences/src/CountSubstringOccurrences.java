import java.util.Scanner;

public class CountSubstringOccurrences {

    public static void main(String[] args) {


            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine().toLowerCase();
            String pattern = scan.nextLine().toLowerCase();

            printResult(findOccurancies(text,pattern));
    }

    private static int findOccurancies(String text, String pattern) {
        int count = 0;
        int i = 0;
        while (text.indexOf(pattern, i) != -1) {
            count++;
            i = text.indexOf(pattern,i)+1;
        }
        return count;
    }

    private static void printResult(int count) {
        System.out.println(count);
    }
}
