package AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String name = reader.readLine();
        Integer age = Integer.parseInt(reader.readLine());

        try {
            Chicken chicken = new Chicken(name, age);

            System.out.println("Chicken " + chicken.getName() + " (age " + chicken.getAge() + ") can produce " + chicken.eggsPerDay() + " eggs per day.");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

    }
}
