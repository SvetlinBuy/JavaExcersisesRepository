package PizzaCalories;

public class Toppings {

    private double calories;

    private void setCalories(double weight) {
        double caloriesBASE = 2;
        this.calories = weight * caloriesBASE;
    }


    public Toppings(double weight) {

        setCalories(weight);

    }

    public double getCalories() {
        return calories;
    }

    public void addIngredients(String top) {

        if(!top.equals("Meat")
                && !top.equals("Veggies")
                && !top.equals("Cheese")
                && !top.equals("Sause")){

            throw new IllegalArgumentException("Cannot place "+ top +" on top of your pizza.");
        }

        switch (top) {

            case "Meat":
                double meat = 1.2;
                calories *= meat;
                break;
            case "Veggies":
                double veggies = 0.8;
                calories *= veggies;
                break;
            case "Cheese":
                double cheese = 1.1;
                calories *= cheese;
                break;
            case "Sause":
                double sause = 0.9;
                calories *= sause;
                break;
        }
    }
}
