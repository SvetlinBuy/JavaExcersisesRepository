import java.util.Scanner;

public class FilltheMatrix {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int matrixSize = Integer.parseInt(input.nextLine());
        String matrixPattern = input.nextLine();
        int[][] matrix = new int[matrixSize][matrixSize];

        if (matrixPattern.equals("A")) {
            FillMatrixPatternA(matrix, matrixSize);
        } else if (matrixPattern.equals("B")) {
            FillMatrixPatternB(matrix, matrixSize);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
    }

    private static void FillMatrixPatternB(int[][] matrix, int matrixSize) {
        
        
        
    }

    private static void FillMatrixPatternA(int[][] matrix, int matrixSize) {
        
        
        
    }

}
