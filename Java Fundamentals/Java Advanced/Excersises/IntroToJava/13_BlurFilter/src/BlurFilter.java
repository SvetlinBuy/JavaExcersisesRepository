import java.util.Arrays;
import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scan.nextLine());
        int[] matrixDimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];
        long[][] matrix = new long[rows][cols];


        for (int row = 0; row < rows; row++) {
            String[] elements = scan.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Long.parseLong(elements[col]);

            }

        }

        int[] bc = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                if (row == bc[0] - 1 && col == bc[1] - 1) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] - 1 && col == bc[1]) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] - 1 && col == bc[1] + 1) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] && col == bc[1] - 1) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] && col == bc[1]) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] && col == bc[1] + 1) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] + 1 && col == bc[1] - 1) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] + 1 && col == bc[1]) {
                    matrix[row][col] += blurAmount;
                } else if (row == bc[0] + 1 && col == bc[1] + 1)
                    matrix[row][col] += blurAmount;
            }

        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }
}
