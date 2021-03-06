import java.util.*;

public class StringMatrixRotation {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int degree = Integer.parseInt(input.findInLine("([0-9]+)"));

        List<String> stringHolder = new ArrayList();

        input.nextLine();

        String command = input.nextLine();

        int matrixColSize = 0;

        while (!command.equals("END")) {


            if (command.length() > matrixColSize) {
                matrixColSize = command.length();
            }

            stringHolder.add(command);

            command = input.nextLine();
        }


        matrixRotator(stringHolder, matrixColSize, degree);


    }

    private static void matrixRotator(List<String> stringHolder, int matrixColSize, int degree) {


        char[][] matrix = new char[stringHolder.size()][matrixColSize];


        matrixFiller(matrix, stringHolder);


        int rotateDegree = degree / 90 % 4;


        switch (rotateDegree) {

            case 0:
                matrix = rotateby0degree(matrix);
                break;
            case 1:
                matrix = rotateby90degree(matrix);
                break;
            case 2:
                matrix = rotateby180degree(matrix);
                break;
            case 3:
                matrix = rotateby270degree(matrix);
                break;


        }

        printMatrix(matrix);

    }

    private static char[][] rotateby270degree(char[][] matrix) {

        char[][] rotedmatrix = new char[matrix[0].length][matrix.length];

        for (int i = 0; i < rotedmatrix.length; i++) {

            for (int j = rotedmatrix[0].length - 1; j >= 0; j--) {

                rotedmatrix[i][j] = matrix[j][i];

            }
        }

        reverseMatrixCol(rotedmatrix);
        revverseMatrixRow(rotedmatrix);
        reverseMatrixCol(rotedmatrix);

        return rotedmatrix;

    }

    private static char[][] rotateby180degree(char[][] matrix) {

        char[][] rotedmatrix = new char[matrix.length][matrix[0].length];

        for (int i = 0 ; i < rotedmatrix.length; i++) {

            for (int j = rotedmatrix[0].length -1 ; j >= 0; j--) {

                rotedmatrix[i][j] = matrix[i][j];

            }

        }

        revverseMatrixRow(rotedmatrix);

        reverseMatrixCol(rotedmatrix);

        return rotedmatrix;
    }
    
    private static char[][] rotateby0degree(char[][] matrix) {

        char[][] rotedmatrix = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < rotedmatrix.length; i++) {

            for (int j = 0; j < rotedmatrix[0].length; j++) {

                rotedmatrix[i][j] = matrix[i][j];

            }

        }

        return rotedmatrix;
    }

    private static char[][] rotateby90degree(char[][] matrix) {


        char[][] rotedmatrix = new char[matrix[0].length][matrix.length];

        for (int i = 0; i < rotedmatrix.length; i++) {

            for (int j = rotedmatrix[0].length - 1; j >= 0; j--) {

                rotedmatrix[i][j] = matrix[j][i];

            }
        }

        reverseMatrixCol(rotedmatrix);

        return rotedmatrix;

    }

    private static char[][] reverseMatrixCol(char[][] rotedmatrix) {

        for (int k = 0; k < rotedmatrix.length; k++) {

            char[] tempCharArr = rotedmatrix[k];


            for (int i = 0; i < tempCharArr.length / 2; i++) {
                char temp = tempCharArr[i];
                tempCharArr[i] = tempCharArr[tempCharArr.length - i - 1];
                tempCharArr[tempCharArr.length - i - 1] = temp;
            }

            rotedmatrix[k] = tempCharArr;

        }

        return  rotedmatrix;
    }

    private static char[][] revverseMatrixRow(char[][] rotedmatrix) {

        for (int i = 0; i < rotedmatrix.length / 2; i++) {
            char[] temp = rotedmatrix[i];
            rotedmatrix[i] = rotedmatrix[rotedmatrix.length - i - 1];
            rotedmatrix[rotedmatrix.length - i - 1] = temp;
        }


        return rotedmatrix;
    }


    private static void matrixFiller(char[][] matrix, List<String> stringHolder) {

        for (int i = 0; i < matrix.length; i++) {

            char[] word = stringHolder.get(i).toCharArray();

            for (int j = 0; j < matrix[0].length; j++) {

                if (word.length > j) {
                    matrix[i][j] = word[j];
                } else {
                    matrix[i][j] = ' ';
                }
            }

        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j]);

            }

            System.out.println();
        }

    }

}
