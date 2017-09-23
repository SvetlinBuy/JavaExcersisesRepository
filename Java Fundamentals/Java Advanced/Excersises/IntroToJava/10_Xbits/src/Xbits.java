import java.util.Scanner;
public class Xbits {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] binaries = new String[8];
        for (int i = 0; i < 8; i++) {

            String binary = String.format("%32s", Integer.toBinaryString(Integer.parseInt(input.nextLine()))).replace(' ', '0');
            binaries[i] = binary;
        }
        int counter = 0;
        for (int j = 0; j < binaries.length - 2; j++) {
            for (int k = 0; k < binaries[j].length() - 2; k++) {
                String a = binaries[j].charAt(k) + "" + binaries[j].charAt(k + 1) + binaries[j].charAt(k + 2);
                String b = binaries[j + 1].charAt(k) + "" + binaries[j + 1].charAt(k + 1) + binaries[j + 1].charAt(k + 2);
                String c = binaries[j + 2].charAt(k) + "" + binaries[j + 2].charAt(k + 1) + binaries[j + 2].charAt(k + 2);
                if (a.equals("101") && b.equals("010") && c.equals("101")) {
                    counter++;
                }

            }
        }
        System.out.println(counter);

    }
}
