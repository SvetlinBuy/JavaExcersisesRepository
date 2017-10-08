import java.util.Scanner;

public class CalculateExpression {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double f1 = Math.pow(((Math.pow(a,2) + Math.pow(b,2)) / (Math.pow(a,2) - Math.pow(b,2))),((a + b + c) / Math.sqrt(c)));

        double f2 = Math.pow((Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,3)),(a - b));

        CalculateExpression calc = new CalculateExpression();

        double diff = Math.abs( calc.AverageABC(a, b, c) - (f1 + f2)/2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);

    }

    private double AverageABC(double a, double b, double c) {

       double average = (a + b + c) / 3;

       return average;
    }

}
