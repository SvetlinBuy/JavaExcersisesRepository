import java.util.Arrays;
import java.util.Scanner;

public class KnightsofHonor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" ")).forEach(st->{System.out.println("Sir " + st);});

    }
}
