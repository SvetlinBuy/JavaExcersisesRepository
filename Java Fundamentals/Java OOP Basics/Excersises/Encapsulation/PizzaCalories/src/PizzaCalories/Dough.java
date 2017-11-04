package PizzaCalories;

public class Dough {

    private double calories;

    private void setCalories(double weight) {

        if(weight < 1 || weight > 200){

            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        double caloriesBASE = 2;
        this.calories = weight * caloriesBASE;
    }

    public Dough(double weight) {
        this.setCalories(weight);
    }

    public double getCalories() {
        return calories;
    }

    public void addIngredients(String dough) {

        boolean isWhite = dough.equals("White");
        boolean isWholegrain = dough.equals("Wholegrain");
        boolean isCrispy = dough.equals("Crispy");
        boolean isChewy= dough.equals("Chewy");
        boolean isHomemade = dough.equals("Homemade");


        if( !isWhite && !isWholegrain && !isCrispy && !isChewy && !isHomemade  ){

            throw  new IllegalArgumentException("Invalid type of dough.");

        }

        switch (dough) {

            case "White":
                double white = 1.5;
                calories *= white;
                break;
            case "Wholegrain":
                double wholegrain = 1.0;
                calories *= wholegrain;
                break;
            case "Crispy":
                double crispy = 0.9;
                calories *= crispy;
                break;
            case "Chewy":
                double chewy = 1.1;
                calories *= chewy;
                break;
            case "Homemade":
                double homemade = 1.0;
                calories *= homemade;
                break;
        }
    }
}
