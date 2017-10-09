import java.util.Arrays;
import java.util.Scanner;

public class TheStockSpanProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int price[] = new int[n];

        for (int i = 0; i < n; i++) {

            price[i] = Integer.parseInt(scanner.nextLine());
        }

        int m = price.length;
        int S[]= new int[m];

        // Fill the span values in array S[]
        calculateSpan(price, m, S);

        // print the calculated span values
        printArray(S);
    }

    //  method to calculate stock span values
    static void calculateSpan(int price[], int n, int S[])
    {
        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++)
        {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--)
                S[i]++;
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }
}
