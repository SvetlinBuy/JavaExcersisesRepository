package FoodShortage;

public class Citizen implements Buyer {

    private String name;
    private Integer age;
    private String id;
    private String birthDate;
    private Food food;


    public Citizen(String name, Integer age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = new Food(0);
    }




    @Override
    public void buyFood() {

        this.food.setFood(this.food.getFood()+10);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Food getFood() {
        return this.food;
    }
}
