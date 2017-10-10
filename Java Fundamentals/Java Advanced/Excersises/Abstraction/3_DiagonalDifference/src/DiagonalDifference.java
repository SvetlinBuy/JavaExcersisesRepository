import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {

            String[] line = input.nextLine().split(" ");

            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = Integer.parseInt(line[j]);

            }

        }

        int Diff = Math.abs(primaryDiagSum(matrix) - secondaryDiagSum(matrix, n));

        System.out.println(Diff);

    }

    private static int secondaryDiagSum(int[][] matrix, int n) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {

            sum += matrix[i][n-1-i];

        }

        return  sum;
    }

    private static int primaryDiagSum(int[][] matrix) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {

            sum += matrix[i][i];

        }

        return  sum;
    }



}
