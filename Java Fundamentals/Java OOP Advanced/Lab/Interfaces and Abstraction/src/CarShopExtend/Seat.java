package CarShopExtend;

public class Seat implements Sellable {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;


    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    public String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return "This is " + this.getModel() + " produced in " + this.getCountryProduced() + " and have " + Car.TIRES + " tires";
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
