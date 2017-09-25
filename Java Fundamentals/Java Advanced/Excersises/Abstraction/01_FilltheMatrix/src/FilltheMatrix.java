import java.util.Scanner;

public class FilltheMatrix {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] initalInput = input.nextLine().split(", ");

        int matrixSize = Integer.parseInt(initalInput[0]);
        String matrixPattern = initalInput[1];
        int[][] matrix = new int[matrixSize][matrixSize];

        if (matrixPattern.equals("A")) {
            FillMatrixPatternA(matrix, matrixSize);
        } else if (matrixPattern.equals("B")) {
            FillMatrixPatternB(matrix, matrixSize);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j]+" ");

            }

            System.out.println();
        }

    }

    private static void FillMatrixPatternB(int[][] matrix, int matrixSize) {

        int startNumb = 1;
        for (int i = 0; i < matrix.length; i++) {

            if (i % 2 == 0 ){
                for (int j = 0; j < matrix[0].length; j++) {

                    matrix[j][i] += startNumb;
                    startNumb++;
                }
            } else {
                for (int k = matrix[0].length -1; k >= 0  ; k--) {
                    matrix[k][i] += startNumb;
                    startNumb++;
                }
            }

        }
    }

    private static void FillMatrixPatternA(int[][] matrix, int matrixSize) {


        int startNumb = 1;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                matrix[j][i] += startNumb;
                startNumb++;
            }
        }
    }

}
