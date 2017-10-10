import java.util.*;

public class HandsofCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Set<String>> playerscards = new LinkedHashMap<>();

        while (!line.equals("JOKER")) {

            String playerName = line.split(":")[0];

            String[] playerHand = line.split(": ")[1].split(", ");

            if (playerscards.containsKey(playerName)) {

                for (Map.Entry<String, Set<String>> kv : playerscards.entrySet()) {

                    Set<String> existingHand = kv.getValue();

                    for (int i = 0; i < playerHand.length; i++) {

                        existingHand.add(playerHand[i]);
                    }
                }

            } else {
                Set<String> handHolder = new HashSet<>();

                for (int i = 0; i < playerHand.length; i++) {

                    handHolder.add(playerHand[i]);

                }

                playerscards.put(playerName, handHolder);
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> kv: playerscards.entrySet()) {

            String playerName = kv.getKey();

            Set<String> existingHand = kv.getValue();

            int handValue = cardTotalValueCalc(existingHand);

            System.out.println(playerName + ": " + handValue);

        }

    }

    private static int cardTotalValueCalc(Set<String> existingHand) {


        int handValue = 0;

        for (String card: existingHand) {

            String power = card.split("")[0];
            String multipler = card.split("")[1];

            int p = cardpower(power);
            int m = cardmultipler(multipler);

            handValue += p * m;

        }


        return handValue;
    }

    private static int cardmultipler(String multipler) {

        char c = multipler.charAt(0);

        switch (c) {

            case 'S': return 4;
            case 'H': return 3;
            case 'D': return 2;
            case 'C': return 1;
            default: return 0;

        }
    }

    private static int cardpower(String power) {

            char c = power.charAt(0);

            switch (c){

                case 'J': return 11;
                case 'Q': return 12;
                case 'K': return 13;
                case 'A': return 14;
                default: return Integer.parseInt(power);
            }


    }
}
