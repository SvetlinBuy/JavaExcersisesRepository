import java.util.Scanner;

public class MatrixofPalindromes {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] initalInput = input.nextLine().split(" ");

        int rowCount = Integer.parseInt(initalInput[0]);
        int columnCount = Integer.parseInt(initalInput[0]);

        String[][] matrix = new String[rowCount][columnCount];

        PalidromeMatrixFiller(matrix, rowCount, columnCount);


        printMatrix(matrix);


    }

    private static void PalidromeMatrixFiller(String[][] matrix, int rowCount, int columnCount) {


        for (int i = 0; i < matrix.length ; i++) {

            Character row = 'a';

            for (int j = 0; j < matrix[0].length; j++) {



            }

            row++;
        }



    }

    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j]+" ");

            }

            System.out.println();
        }

    }
}
