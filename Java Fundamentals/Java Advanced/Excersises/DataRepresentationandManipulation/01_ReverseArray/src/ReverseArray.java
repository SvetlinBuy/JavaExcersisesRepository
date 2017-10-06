import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        reverseArrR(input, 0, input.length -1);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+ " ");
        }

    }

   private static void reverseArrR(String[] arr, int start, int end) {
        if (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArrR(arr, start + 1, end - 1);

        }
    }
}
