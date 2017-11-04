package RandomArrayList;

public class Main {


    public static void main(String[] args) {

        RandomArrayList ral = new RandomArrayList();

        ral.add("a");
        ral.add(1);
        ral.add("b");
        ral.add(2);
        ral.add("c");
        ral.add(3);
        ral.add("d");
        ral.add(4);

        System.out.println(ral.getRandomElement());
    }

}
