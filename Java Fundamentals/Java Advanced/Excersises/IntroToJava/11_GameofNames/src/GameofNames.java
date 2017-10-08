import java.math.BigDecimal;
import java.util.Scanner;

public class GameofNames {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());

        if (N >= 1 && N <= 100 ) {

            String winnerName = "";
            int winnerScore = Integer.MIN_VALUE;


            for (int i = 0; i < N; i++) {

                String playerName = input.nextLine();
                int initialScore = Integer.parseInt(input.nextLine());
                int currentScore = initialScore;

                if (playerName.length() > 30) {
                    continue;
                }

                for (int j = 0; j < playerName.length(); j++) {

                    if (playerName.charAt(j) % 2 == 0) {

                        currentScore += playerName.charAt(j);
                    }
                    else {
                        currentScore -= playerName.charAt(j);
                    }
                }

                if (currentScore > winnerScore) {
                    winnerScore = currentScore;
                    winnerName = playerName;
                }

            }

            System.out.printf("The winner is %s - %d points", winnerName, winnerScore);
        }

    }

}
