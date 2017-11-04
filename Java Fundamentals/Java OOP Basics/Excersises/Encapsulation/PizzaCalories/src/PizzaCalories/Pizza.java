package PizzaCalories;


import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private double toppingCalories;

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppingCalories(double toppingCalories) {

        this.toppingCalories += toppingCalories;
    }

    public String getName() {
        return name;
    }

    public Pizza(String name) {
        this.setName(name);
    }

    public void setName(String name) {

        if(name.isEmpty() || name.length() > 15 || name.equals("\\s+")){

            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");

        }
        this.name = name;
    }


    public void addDough(List<String> doughList, double initialGrams) {

        Dough dough = new Dough(initialGrams);

        for (String dname : doughList) {

            String name = dname.toUpperCase().charAt(0) + dname.substring(1, dname.length());


            dough.addIngredients(name);

        }

        setDough(dough);

    }

    public void addTopping(String topping, double initialGrams) {

        if(initialGrams < 1 || initialGrams > 50){

            throw new IllegalArgumentException(topping + " weight should be in the range [1..50].");
        }

        Toppings toppings = new Toppings(initialGrams);

        String name = topping.toUpperCase().charAt(0) + topping.substring(1, topping.length());

        toppings.addIngredients(name);

        setToppingCalories(toppings.getCalories());

    }

    public double getPizzaCalories() {

        return this.dough.getCalories() + this.toppingCalories;

    }
}
