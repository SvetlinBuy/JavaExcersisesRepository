import java.util.Scanner;

public class RectangleArea {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double a = input.nextDouble();
        double b = input.nextDouble();
        double area = a * b;

        System.out.printf("%.2f", area);

    }
}
