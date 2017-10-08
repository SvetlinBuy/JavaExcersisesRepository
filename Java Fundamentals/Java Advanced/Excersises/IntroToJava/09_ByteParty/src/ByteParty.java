import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ByteParty {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());

        int[] arrint = new int[N];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arrint.length ; i++) {

            arrint[i] = Integer.parseInt(input.nextLine());

        }

        String line = input.nextLine();

        while (!line.equals("party over"))  {

            String[] lineArr = line.split(" ");

            int action = Integer.parseInt(lineArr[0]);
            int position = Integer.parseInt(lineArr[1]);

            switch (action) {
                case -1:
                    for (int i = 0; i < arrint.length; i++) {
                        arrint[i] = arrint[i] ^ (1 << position);
                    }
                    break;
                case 0:
                    for (int i = 0; i < arrint.length; i++) {
                        int mask = ~(1 << position);
                        arrint[i] = arrint[i] & mask;
                    }
                    break;
                case 1:
                    int mask1 = (1 << position);
                    for (int i = 0; i < arrint.length; i++) {
                        arrint[i] = arrint[i] | mask1;
                    }
                    break;
            }

            line = input.nextLine();
        }

        for/*each*/ (int number:/*in*/arrint) {
            System.out.println(number);
        }
    }
}
