package WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;


public class Main {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        List<Animal> animals = new ArrayList<>();

        String command = reader.readLine();

        while (!command.equalsIgnoreCase("End")) {

            String[] token = command.split("\\s+");

            Animal animal = createAnimal(token);

            String[] foodToken = reader.readLine().split("\\s+");

            Food food = createFood(foodToken);

            System.out.println(animal.makeSound());

            try{

                animal.eat(food, food.getQuantity());
            }catch (IllegalArgumentException e){

                System.out.println(e.getMessage());
            }


            animals.add(animal);
            command = reader.readLine();
        }


        animals.forEach( System.out::println);
    }

    private static Food createFood(String[] foodToken) {

        int quantity = Integer.parseInt(foodToken[1]);

        switch (foodToken[0]) {

            case "Vegetable":
                return new Vegetable(quantity);

            case "Meat":
                return new Meat(quantity);
            default:
                return null;

        }


    }

    private static Animal createAnimal(String[] tokens) {

        String name = tokens[1];
        String type = tokens[0];
        Double weight = Double.parseDouble(tokens[2]);
        String region = tokens[3];


        switch (tokens[0]) {


            case "Cat":
                return new Cat(name, type, weight, region, tokens[4]);
            case "Tiger":
                return new Tiger(name, type, weight, region);

            case "Zebra":
                return new Zebra(name, type, weight, region);

            case "Mouse":
                return new Mouse(name, type, weight, region);
            default:
                return null;
        }

    }

}
