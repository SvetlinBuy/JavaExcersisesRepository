package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] pizzaInput = reader.readLine().split(" ");

        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);

        try {

            if(numberOfToppings < 0 || numberOfToppings > 10){
                throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
            }

            Pizza pizza = new Pizza(pizzaName);

            String[] doughInput = reader.readLine().split(" ");

            double grams = Double.parseDouble(doughInput[doughInput.length - 1]);
            List<String> doughts = new ArrayList<>();

            for (int i = 1; i < doughInput.length - 1; i++) {

                doughts.add(doughInput[i]);

            }


            pizza.addDough(doughts, grams);

            String top = reader.readLine();

            while (!top.equals("END")) {

                if(numberOfToppings == 0){

                    break;
                }
                String topping = top.split(" ")[1];
                double gramsT = Double.parseDouble(top.split(" ")[2]);



                numberOfToppings--;
                pizza.addTopping(topping, gramsT);


                top = reader.readLine();
            }


            System.out.println(pizza.getName() + " - " + String.format("%.2f", pizza.getPizzaCalories()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
