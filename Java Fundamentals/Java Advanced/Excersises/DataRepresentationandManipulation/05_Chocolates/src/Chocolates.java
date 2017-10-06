import java.util.Arrays;
import java.util.Scanner;

public class Chocolates {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(l -> Integer.parseInt(l)).toArray();
        int m = Integer.parseInt(scanner.nextLine());

        Arrays.sort(numArr);

        int minDiff = minimalDifference(numArr, m, 0, numArr[m-1] - numArr[0]);

        System.out.printf("Min Difference is %d.", minDiff);

    }

    private static int minimalDifference(int[] numArr, int m, int lenght, int result) {

        int start = numArr[m -1] - numArr[lenght];
        int next = Integer.MAX_VALUE;
        if(m < numArr.length) {
            next = numArr[m] - numArr[lenght+1];
        } else {
            return result;
        }


        if (start > next) {

            result = next;
        }

        if (lenght < numArr.length) {
            return minimalDifference(numArr, m+1, lenght +1, result);
        } else {
            return result;
        }
    }
}


