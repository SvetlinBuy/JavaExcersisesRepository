import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class InfernoIII {

    public static void main(String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Predicate<Integer>> database = new HashMap<>();

        while (true) {
            String[] input = read.readLine().split(";");
            if ("Forge".equalsIgnoreCase(input[0])) {
                break;
            }
            Predicate<Integer> predicate = makePredicate(input, arr);

            if ("exclude".equalsIgnoreCase(input[0])) {
                database.put(input[1] + input[2], predicate);
            } else {
                database.remove(input[1] + input[2]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            boolean forRemove = false;
            for (Map.Entry<String, Predicate<Integer>> entry : database.entrySet()) {
                if (entry.getValue().test(i)) {
                    forRemove = true;
                    break;
                }
            }
            if (!forRemove) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    private static Predicate<Integer> makePredicate(String[] input, int[] arr) {
        switch (input[1].toUpperCase()) {
            case "SUM LEFT":
                return i -> ((i > 0 ? arr[i - 1] : 0) + arr[i]) == Integer.parseInt(input[2]);
            case "SUM RIGHT":
                return i -> ((i < arr.length - 1 ? arr[i + 1] : 0) + arr[i]) == Integer.parseInt(input[2]);
            default:
                return i -> ((i < arr.length - 1 ? arr[i + 1] : 0) + arr[i] +
                        (i > 0 ? arr[i - 1] : 0)) == Integer.parseInt(input[2]);

        }
    }
}
