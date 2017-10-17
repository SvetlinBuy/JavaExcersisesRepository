import java.util.Scanner;
import java.util.StringJoiner;

public class LittleJohn {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int[] count = {0,0,0};
        String[] arrows = {">----->", ">>----->", ">>>----->>"};

        for (int i = 0; i < 4; i++) {

            String row = scanner.nextLine();

            while(row.contains(arrows[2])){

                count[2]++;

                row = row.replaceFirst(arrows[2], "X");
            }


            while(row.contains(arrows[1])) {

                count[1]++;

                row = row.replaceFirst(arrows[1], "X");
            }

           while(row.contains(arrows[0])) {

                count[0]++;
               row = row.replaceFirst(arrows[0], "X");
            }
        }


        int toConvert = Integer.parseInt(count[0] +""+ count[1] +""+ count[2] + "");

        String binaryString = Integer.toBinaryString(toConvert);

        StringBuilder sb = new StringBuilder("");

        sb.append(binaryString);

        sb.reverse();

        String reversed = sb.toString();

        int convertedNumber =  Integer.parseInt(binaryString + reversed, 2);

        System.out.println(convertedNumber);

    }


}
