package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Unknown> beings = new ArrayList<>();

        List<BirthDate> birthdayBuddies = new ArrayList<>();

        String command = scanner.nextLine();

        while(!command.equals("End")){

            String[] data = command.split(" ");

            if(data.length == 3){

                if(data[0].equals("Pet")){

                    BirthDate pet = new Pet(data[1], data[2]);

                    birthdayBuddies.add(pet);

                } else{
                    Unknown robot = new Robot(data[1], data[2]);

                    beings.add(robot);
                }



            } else if ( data.length == 5) {

                Unknown citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3]);

                BirthDate citizenb = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);

                beings.add(citizen);
                birthdayBuddies.add(citizenb);

            }

            command = scanner.nextLine();
        }

        String date = scanner.nextLine();


        for (BirthDate bd: birthdayBuddies) {

            if(bd.getDate().endsWith(date)){

                System.out.println(bd.getDate());
            }
        }
    }
}
