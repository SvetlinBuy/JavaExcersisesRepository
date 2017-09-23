import java.util.Scanner;

public class FirstOddOrEvenElements {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] arrStr = input.nextLine().split(" ");
        String[] commands = input.nextLine().split(" ");

        int arrSize = Integer.parseInt(commands[1]);

        if (Integer.parseInt(commands[1]) > arrStr.length) {
            arrSize= arrStr.length+1;
        }

        int[] arrInt = new int[arrSize];
        int count = 0;

        if (commands[2].equals("even")) {

            for (int i = 0; i < arrStr.length; i++) {

                if (count == arrSize) {
                    break;
                }
                if (Integer.parseInt(arrStr[i]) % 2 == 0) {

                    arrInt[count] = Integer.parseInt(arrStr[i]);
                    count ++;
                }
            }
        } else if (commands[2].equals("odd")) {

            for (int i = 0; i < arrStr.length; i++) {

                if (count == arrSize) {
                    break;
                }
                if (Integer.parseInt(arrStr[i]) % 2 == 1) {

                    arrInt[count] = Integer.parseInt(arrStr[i]);
                    count ++;
                }
            }
        }


        for (int i = 0; i < arrInt.length ; i++) {

            if (i == count) {
                break;
            }
            System.out.print(arrInt[i] + " ");
        }

    }

}
