import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();

        double b = input.nextDouble();
        double c = input.nextDouble();

        input.nextLine();

        String hex = Integer.toHexString(a);

        String binaryString = Integer.toBinaryString(a);

        StringBuilder tenABinary = new StringBuilder(binaryString);
        while (tenABinary.length() < 10) {
            tenABinary.insert(0, 0);
        }

        System.out.printf("|%-10s|%-10s|%10.2f|%-10.3f|",hex.toUpperCase(), tenABinary,b,c);


    }

}
