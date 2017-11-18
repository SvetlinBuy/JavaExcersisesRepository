package ShopingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> bag;


    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.setBag(new ArrayList<>());
    }
    public String getName() {
        return name;
    }

    public List<Product> getBag() {
        return bag;
    }

    private void setName(String name) {
        if (name.trim().length() == 0 || name == null ) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setBag(List<Product> bag) {
        this.bag = bag;
    }

    public void buyProduct (Product product){

        if(money <= product.getCost()){
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }

        money -= product.getCost();
        bag.add(product);

        System.out.println(name +" bought " + product.getName());
    }
}
