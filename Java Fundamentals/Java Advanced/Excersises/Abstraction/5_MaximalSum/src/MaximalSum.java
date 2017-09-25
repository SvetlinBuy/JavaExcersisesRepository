import java.util.Collection;
import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] initalInput = input.nextLine().split(" ");

        int rowCount = Integer.parseInt(initalInput[0]);
        int columnCount = Integer.parseInt(initalInput[1]);

        int[][] matrix = new int[rowCount][columnCount];


        for (int i = 0; i < matrix.length; i++) {

            String[] line = input.nextLine().split(" ");

            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = Integer.parseInt(line[j]);

            }
        }

        int[] sum = CalculateMaximalSum3of3Square(matrix);


        System.out.println("Sum = " + sum[0]);
        printMatrix(matrix, sum[1], sum[2]);


    }


    private static void printMatrix(int[][] matrix, int startRow, int startColumn) {


        for (int i = startRow; i < matrix.length; i++) {


            if (i - startColumn == 3) {
                break;
            }

            for (int j = startColumn; j < matrix[0].length; j++) {

                if (j - startColumn == 3) {
                    continue;
                }
                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }

    }

    private static int[] CalculateMaximalSum3of3Square(int[][] matrix) {

        int sum = Integer.MIN_VALUE;

        int startRow = 0;
        int startColumn = 0;

        for (int i = 0; i < matrix.length - 2; i++) {

            for (int j = 0; j < matrix[0].length - 2; j++) {

                int currentSum =
                        matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                                matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                                matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (currentSum > sum) {
                    sum = currentSum;

                    startRow = i;
                    startColumn = j;
                }
            }

        }

        int[] sumArr = {sum, startRow, startColumn};

        return sumArr;

    }

}
