import java.util.Scanner;

public class MultiplyBigNumber {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine().trim();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        if (firstNumber == "0" || secondNumber == 0 || firstNumber == "")
        {
            System.out.println(0);
            return;
        }

        int product = 0;
        int numberInMind = 0;
        int remainder = 0;
        StringBuilder result = new StringBuilder();

        for (int i = firstNumber.length() - 1; i >= 0 ; i--)
        {
            product = (int)(Integer.parseInt(firstNumber.toCharArray()[i] + "") * secondNumber + numberInMind);
            numberInMind = (int)(product / 10);
            remainder = (int)(product % 10);
            result.append(remainder);
            if (i == 0 && numberInMind != 0)
            {
                result.append(numberInMind);
            }

        }

        char[] resultToCharArr = result.toString().toCharArray();
        reverseArr(resultToCharArr);

        for (int i = 0; i < resultToCharArr.length; i++) {
            System.out.print(resultToCharArr[i]);

        }


    }

    private static void reverseArr(char[] A) {

        int idx = 0;
        for (int i = A.length - 1; i >= A.length / 2; i--) {

            char temp = A[i];
            A[i] = A[idx];
            A[idx] = temp;
            idx++;
        }
    }
}
