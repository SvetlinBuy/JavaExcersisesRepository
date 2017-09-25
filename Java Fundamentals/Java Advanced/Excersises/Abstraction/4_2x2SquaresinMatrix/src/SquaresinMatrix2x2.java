import java.util.Scanner;

public class SquaresinMatrix2x2 {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        String[] initalInput = input.nextLine().split(" ");

        int rowCount = Integer.parseInt(initalInput[0]);
        int columnCount = Integer.parseInt(initalInput[1]);

        String[][] matrix = new String[rowCount][columnCount];

        for (int i = 0; i < matrix.length; i++) {

            String[] line = input.nextLine().split(" ");

            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = line[j];

            }
        }

        System.out.println(printMatchSquareEqualChars(matrix));

    }

    private static int printMatchSquareEqualChars(String[][] matrix) {

        int matchCount = 0;

        for (int i = 0; i < matrix.length - 1; i++) {

            for (int j = 0; j < matrix[0].length - 1; j++) {

                if (matrix[i][j+1].equals(matrix[i][j])
                        && matrix[i + 1][j].equals(matrix[i][j])
                        && matrix[i + 1][j + 1].equals(matrix[i][j])
                        ) {
                    matchCount++;
                }
            }
        }
        return matchCount;
    }
}
