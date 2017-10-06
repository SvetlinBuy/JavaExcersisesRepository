import java.util.Arrays;
import java.util.Scanner;

public class ImplementBinarySearchusingRecursion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
        int  target = Integer.parseInt(scanner.nextLine());

        int index = binarySearch(numbers,0, numbers.length -1, target);

        System.out.println(index);

    }

    private static int binarySearch(int[] a, int start, int end, int target) {
        int middle = (start + end) / 2;
        if(end < start) {
            return -1;
        }

        if(target==a[middle]) {
            return middle;
        } else if(target<a[middle]) {
            return binarySearch(a, start, middle - 1, target);
        } else {
            return binarySearch(a, middle + 1, end, target);
        }
    }
}
