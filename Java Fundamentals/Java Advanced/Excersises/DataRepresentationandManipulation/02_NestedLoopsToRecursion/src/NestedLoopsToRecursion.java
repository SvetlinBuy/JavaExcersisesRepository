import java.util.Scanner;

public class NestedLoopsToRecursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        int index = 0;
        nestedLoopRecursion(array , index);
    }
    private static void nestedLoopRecursion(int[] n , int index) {
        if(index == n.length){
            for (int num : n) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <=n.length; i++) {
            n[index] = i;
            nestedLoopRecursion(n , index + 1);
        }
    }

}


