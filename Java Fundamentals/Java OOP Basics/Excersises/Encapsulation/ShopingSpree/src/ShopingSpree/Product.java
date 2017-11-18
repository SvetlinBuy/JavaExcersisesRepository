package ShopingSpree;

public class Product {

    private String name;
    private double cost;

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public Product(String name, double cost) {

        this.setName(name);
        this.setCost(cost);

    }

    private void setName(String name) {
        if (name.trim().length() == 0 || name == null ) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
}
