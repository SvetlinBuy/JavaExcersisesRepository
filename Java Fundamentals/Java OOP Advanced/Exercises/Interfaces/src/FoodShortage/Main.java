package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {

            String[] command = scanner.nextLine().split(" ");

            String name = command[0];
            int age = Integer.parseInt(command[1]);
            String groupID = command[2];

            if (command.length == 4) {

                String bd = command[3];

                Buyer citizen = new Citizen(name,age,groupID,bd);

                buyers.add(citizen);

            } else if (command.length == 3){

                Buyer rebel = new Rebel(name,age,groupID);

                buyers.add(rebel);

            }

        }

        String com = scanner.nextLine();

        while (!com.equals("End")) {

            for (Buyer b :buyers) {

               if(b.getName().equals(com)){

                   b.buyFood();

               }
            }


            com = scanner.nextLine();
        }

        int amountfood = 0;

        for (Buyer by: buyers) {

            amountfood += by.getFood().getFood();

        }

        System.out.println(amountfood);

    }
}
