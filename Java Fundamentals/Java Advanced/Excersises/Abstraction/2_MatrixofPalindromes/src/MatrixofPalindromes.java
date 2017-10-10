import java.util.Scanner;

public class MatrixofPalindromes {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] initalInput = input.nextLine().split(" ");

        int rowCount = Integer.parseInt(initalInput[0]);
        int columnCount = Integer.parseInt(initalInput[1]);

        String[][] matrix = new String[rowCount][columnCount];

        PalidromeMatrixFiller(matrix);


        printMatrix(matrix);


    }

    private static void PalidromeMatrixFiller(String[][] matrix) {

        Character row = 'a';

        for (int i = 0; i < matrix.length ; i++) {


            Character column = row;


            for (int j = 0; j < matrix[0].length; j++) {

                 String element = row + "" + column + "" + row;

                 matrix[i][j] = element;

                 column++;

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
