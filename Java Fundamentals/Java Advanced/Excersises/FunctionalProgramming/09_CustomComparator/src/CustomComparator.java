import java.util.*;

public class CustomComparator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(m -> Integer.parseInt(m)).toArray();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list, new EvenOddComparator());

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i) + " ");
        }

    }

    private static class EvenOddComparator implements Comparator<Integer>
    {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 % 2 == 0 && o2 % 2 != 0) {
                return BEFORE;
            } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                return AFTER;
            } else if (o1 % 2 == 0 && o2 % 2 == 0) {
                return o1.compareTo(o2);
            } else if (o1 % 2 != 0 && o2 % 2 != 0) {
                return o1.compareTo(o2);
            }
            return EQUAL;
        }

    }
}
