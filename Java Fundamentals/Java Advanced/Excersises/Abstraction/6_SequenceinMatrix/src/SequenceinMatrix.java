import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SequanceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        int maxCount = 0;
        String maxSeq = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int colSeqCount = 0;
                String currentColString = matrix[i][j]+ ", ";
                for (int k = i; k < matrix.length -1; k++) {
                    if (matrix[k][j].equals(matrix[k+1][j])){
                        colSeqCount++;
                        currentColString += matrix[i][j]+ ", ";

                    }else{
                        break;
                    }
                }

                if (colSeqCount > maxCount){
                    maxCount = colSeqCount;
                    maxSeq = currentColString;
                }


                int rowSeqCount = 0;
                String currentRowString = matrix[i][j]+ ", ";
                int len = Math.min(matrix.length-1, matrix[i].length-1);
                for (int k = i; k < len; k++) {
                    if (matrix[k][k].equals(matrix[k+1][k+1])){
                        rowSeqCount++;
                        currentRowString += matrix[k][k] + ", ";
                    }else{
                        break;
                    }

                }
                if (rowSeqCount > maxCount){
                    maxCount = rowSeqCount;
                    maxSeq = currentRowString;
                }
            }

        }
        if (maxSeq.equals("")){
            maxSeq = matrix[0][0] + ", ";
        }
        System.out.println(maxSeq.substring(0, maxSeq.length()-2));
    }
}
