package FoodShortage;

public class Rebel implements Buyer {

    private String name;
    private Integer age;
    private  String group;
    private  Food food;

    public Rebel(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = new Food(0);
    }

    @Override
    public void buyFood() {
        this.food.setFood(this.food.getFood()+5);
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
