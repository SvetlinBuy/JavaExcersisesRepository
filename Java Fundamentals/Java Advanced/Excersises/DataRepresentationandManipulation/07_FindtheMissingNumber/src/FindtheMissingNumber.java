import java.util.Arrays;
import java.util.Scanner;

public class FindtheMissingNumber {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());

   int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(m -> Integer.parseInt(m)).toArray();

        Arrays.sort(arr);

        int missing = 0;

        for (int i = 1; i < arr.length; i++) {

            if(arr[0] != 1){

                missing = 2;
                break;
            }

            int num1 = arr[i];
            int num2 =arr[i-1] + 1;


            if(num1 != num2) {

                missing = num1;
                break;
            }
        }

        System.out.println(missing -1);

    }
}
