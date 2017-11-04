import java.util.HashMap;
import java.util.Scanner;
import java.util.OptionalDouble;

public class FootballTeamGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Team> teams = new HashMap<>();

        while (!input.equals("END")) {

            String[] inputArgs = input.split(";");
            String currentCommand = inputArgs[0];

            switch (currentCommand) {
                case "Team":
                    try {
                        Team team = new Team(inputArgs[1]);
                        teams.putIfAbsent(inputArgs[1], team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (teams.containsKey(inputArgs[1])) {
                        System.out.println(String.format("%s - %.0f", inputArgs[1], teams.get(inputArgs[1]).calculateRating()));
                    } else {
                        System.out.println("Team " + inputArgs[1] + " does not exist.");
                    }
                    break;
                case "Remove":
                    if (teams.containsKey(inputArgs[1])) {
                        try {
                            teams.get(inputArgs[1]).removePlayer(inputArgs[2]);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Team " + inputArgs[1] + " does not exist.");
                    }
                    break;
                case "Add":
                    int endurance = Integer.valueOf(inputArgs[3]);
                    int sprint = Integer.valueOf(inputArgs[4]);
                    int dribble = Integer.valueOf(inputArgs[5]);
                    int passing = Integer.valueOf(inputArgs[6]);
                    int shooting = Integer.valueOf(inputArgs[7]);

                        if (teams.containsKey(inputArgs[1])) {
                            try {
                                Player player = new Player(inputArgs[2], endurance, sprint, dribble, passing, shooting);
                                teams.get(inputArgs[1]).addPlayer(player);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }

                        } else {
                            System.out.println("Team " + inputArgs[1] + " does not exist.");
                        }



                    break;
            }
            input = scanner.nextLine();
        }

    }
}

class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;


    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double getAverage() {
        return this.calculateAverage();
    }


    private double calculateAverage() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }
}



class Team {
    private String name;
    private HashMap<String, Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void removePlayer(String player) {
        if (players.containsKey(player)) {
            players.remove(player);
        } else {
            throw new IllegalArgumentException("Player " + player + " is not in " + this.name + " team.");
        }
    }

    public double calculateRating() {
        OptionalDouble average = this.players.entrySet().stream().mapToDouble(x -> x.getValue().getAverage()).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            return 0;
        }
    }

}

