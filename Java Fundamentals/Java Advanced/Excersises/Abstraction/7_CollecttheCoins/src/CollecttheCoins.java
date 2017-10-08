import java.util.Scanner;

public class CollecttheCoins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = new String[4];

        int coins = 0;
        int wallHit = 0;

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < 4; i++) {
            input[i] = scanner.nextLine();

        }

        int col = Math.max(Math.max(input[0].length(), input[1].length()), Math.max(input[2].length(), input[3].length()));
        int row = 4;

        char[][] matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = input[i].toCharArray();

        }

        char[] movement = scanner.nextLine().toCharArray();

        for (int i = 0; i < movement.length; i++) {

            switch (movement[i]) {
                case '<':
                    currentCol--;
                    if (currentCol < 0) {
                        wallHit++;
                        currentCol++;
                    } else {
                        if (matrix[currentRow][currentCol] == '$') {
                            coins++;
                        }
                    }
                    break;
                case '>':
                    currentCol++;
                    if (currentCol > matrix[currentRow].length -1) {
                        wallHit++;
                        currentCol--;
                    } else {
                        if (matrix[currentRow][currentCol] == '$') {
                            coins++;
                        }
                    }
                    break;
                case 'V':
                    currentRow++;
                    if (currentRow > row - 1) {
                        wallHit++;
                        currentRow--;
                    } else if (matrix[currentRow].length -1 < currentCol) {
                        wallHit++;
                        currentRow--;
                    } else {
                        if (matrix[currentRow][currentCol] == '$') {
                            coins++;
                        }
                    }

                    break;
                case '^':
                    currentRow--;
                    if (currentRow < 0) {
                        wallHit++;
                        currentRow++;
                    }else if (matrix[currentRow].length -1 < currentCol) {
                        wallHit++;
                        currentRow--;
                    } else {
                        if (matrix[currentRow][currentCol] == '$') {
                            coins++;
                        }
                    }
                    break;
            }

        }

        System.out.printf("Coins = %1$d\nWalls = %2$d", coins, wallHit);

    }
}
