import java.util.Scanner;

public class CombinationsCount {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        int combinations = nchoosek(n,k);
        System.out.println(combinations);

    }

    private static int nchoosek(int n, int k) {

        if(n < k)
            return 0;
        if(k == 0 || k == n)
            return 1;
        return nchoosek(n-1,k-1)+nchoosek(n-1,k);
    }
}
