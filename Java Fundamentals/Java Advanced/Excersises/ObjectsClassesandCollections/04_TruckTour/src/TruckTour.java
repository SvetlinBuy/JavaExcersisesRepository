import java.util.*;

public class TruckTour {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Deque<Map<Integer, Integer>> queue = queueFiller(count, scanner);
        int index = 0;

        for (int i = 0; i < queue.size(); i++) {

            int numberOfPumpsPassed = rollqueue(queue);

            if (numberOfPumpsPassed < queue.size()) {
                index++;
            } else if (numberOfPumpsPassed == queue.size()) {
                break;
            }
            for (int j = 0; j <= numberOfPumpsPassed; j++) {
                Map<Integer, Integer> pseudo = queue.peekLast();
                queue.pollLast();
                queue.addFirst(pseudo);

            }

            Map<Integer, Integer> pseudo = queue.peekFirst();
            queue.pollFirst();
            queue.addLast(pseudo);


        }

        System.out.println(index);
    }

    private static int rollqueue(Deque<Map<Integer, Integer>> queueR) {

        int count = queueR.size();
        int petrol = queueR.getFirst().entrySet().iterator().next().getKey();
        int counts = 0;

        while(true) {
            if (counts  == count) {

                return counts;
            }
            int currentPetrol = petrol;
            Map<Integer, Integer> petrolDistancepair = queueR.peekFirst();

            queueR.pollFirst();
            Map<Integer, Integer> nextpetrolDistancepair = queueR.peekFirst();
            int nextPumpPetrolAmount = nextpetrolDistancepair.entrySet().iterator().next().getKey();
            int distancetoNextPump = petrolDistancepair.values().iterator().next();
            if (currentPetrol < distancetoNextPump) {
                queueR.addLast(petrolDistancepair);
                return  counts;
            } else {
                counts++; queueR.addLast(petrolDistancepair); petrol = (petrol - distancetoNextPump) + nextPumpPetrolAmount;
            }
        }
    }

    private static Deque<Map<Integer, Integer>> queueFiller(int count, Scanner scanner) {


        Deque<Map<Integer, Integer>> queue = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {

            String[] arr = scanner.nextLine().split(" ");
            int petrolA = Integer.parseInt(arr[0]);
            int distance = Integer.parseInt(arr[1]);

            Map<Integer, Integer> pair = new HashMap<>();

            pair.put(petrolA, distance);

            queue.add(pair);

        }

        return queue;
    }
}
