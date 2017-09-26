import java.util.Scanner;

public class Matrixshuffling {

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


        String commands = input.nextLine();

        while (!commands.equals("END")) {

            String[] command = commands.split(" ");

            if (command[0].equals("swap") && command
                    .length == 5 ) {

                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);


                if (row1  <= rowCount
                        && col1 <= columnCount
                        && row2 <= rowCount
                        && col2 <= columnCount) {


                    String replacer = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = replacer;

                    printMatrix(matrix);



                } else {

                    System.out.println("Invalid input!");
                }


            } else {
                System.out.println("Invalid input!");
            }

            commands = input.nextLine();

        }


    }

    private static void printMatrix(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();
        }

    }

}
