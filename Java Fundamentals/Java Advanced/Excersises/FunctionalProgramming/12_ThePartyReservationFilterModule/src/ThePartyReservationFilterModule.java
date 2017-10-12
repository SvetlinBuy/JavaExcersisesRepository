import java.util.*;

public class ThePartyReservationFilterModule {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<String> listPeople = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        List<String> backupList = new ArrayList<>();

        String commands = scanner.nextLine();

        while (!commands.contains("Print")) {

            String command = commands.split(";")[0];
            String option = commands.split(";")[1];
            String criteria = commands.split(";")[2];

            performAction(command, option, criteria, listPeople, backupList);

            commands = scanner.nextLine();
        }

        printListPeople(listPeople);


    }

    private static List<String> selectPeople(String option, String criteria, List<String> listPeople) {

        List<String> names = new ArrayList<>();

        for (int i = 0; i < listPeople.size(); i++) {

            String name = listPeople.get(i);

            if (option.equals("Starts with")) {
                if (name.startsWith(criteria)) {
                    names.add(name);
                }
            } else if (option.equals("Ends with")) {
                if (name.endsWith(criteria)) {
                    names.add(name);
                }
            } else if (option.equals("Length")) {

                int c = Integer.parseInt(criteria);
                if (name.length() == c) {

                    names.add(name);
                }
            } else if (option.equals("Contains")) {

                if (name.contains(criteria)) {
                    names.add(name);
                }

            }
        }
        return names;
    }

    private static void performAction(String command, String option, String criteria, List<String> listPeople, List<String> backupList) {

        List<String> selectPeoples = selectPeople(option, criteria, listPeople);
        List<String> backupPeoples = selectPeople(option, criteria, backupList);

        if (command.equals("Remove filter")) {

            listPeople.addAll(backupPeoples);
            backupList.removeAll(selectPeoples);


        } else if (command.equals("Add filter")) {

            backupList.addAll(selectPeoples);
            listPeople.removeAll(selectPeoples);

        }

    }

    private static void printListPeople(List<String> listPeople) {



            String s = String.join(" ", listPeople);

            System.out.println(s);

    }
}

