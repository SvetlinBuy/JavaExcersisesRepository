import java.util.Arrays;
import java.util.Scanner;

public class FirstOddOrEvenElements {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] command = scan.nextLine().split(" ");

        int countNum = Integer.parseInt(command[1]);

        String type = command[2];

        if (type.equals("odd")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    System.out.print(arr[i] + " ");
                    countNum--;

                    if (countNum == 0){
                        break;
                    }
                }
            }
        } else if (type.equals("even")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    System.out.print(arr[i] + " ");
                    countNum--;

                    if (countNum == 0){
                        break;
                    }
                }
            }
        }

    }

}
