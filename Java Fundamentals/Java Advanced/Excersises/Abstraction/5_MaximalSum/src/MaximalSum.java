import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int biggestSum = Integer.MIN_VALUE;

        int resultRow = 0;
        int resultCol = 0;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(elements[col]);

            }
        }

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col+2] +
                        matrix[row + 1][col] + matrix[row +1][col +1] + matrix[row +1][col +2] +
                        matrix[row +2][col] + matrix[row +2][col +1] + matrix[row +2][col +2];

                if (sum > biggestSum) {
                    biggestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        System.out.printf("Sum = %d", biggestSum);
        System.out.println();

        System.out.println(matrix[resultRow][resultCol]+ " " + matrix[resultRow][resultCol+1]+ " " + matrix[resultRow][resultCol+2]);
        System.out.println(matrix[resultRow+1][resultCol]+ " " + matrix[resultRow+1][resultCol+1]+ " " + matrix[resultRow +1][resultCol+2]);
        System.out.println(matrix[resultRow+2][resultCol]+ " " + matrix[resultRow+2][resultCol+1]+ " " + matrix[resultRow +2][resultCol+2]);




    }
}
