package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Unknown> beings = new ArrayList<>();

        String command = scanner.nextLine();

        while(!command.equals("End")){

            String[] data = command.split(" ");

            if(data.length == 2){

                Unknown robot = new Robot(data[0], data[1]);

                beings.add(robot);

            } else if ( data.length == 3) {

                Unknown citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);

                beings.add(citizen);

            }

            command = scanner.nextLine();
        }

        String fakeIds = scanner.nextLine();


        for (Unknown being: beings) {

            if(being.getId().endsWith(fakeIds)){

                System.out.println(being.getId());
            }
        }
    }
}
