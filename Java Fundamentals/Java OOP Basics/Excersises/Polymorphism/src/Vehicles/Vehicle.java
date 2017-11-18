package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    protected double DEFAULT_CONSUPTION_SUMMER;

    private double quantity;
    private double consumption;

    public double getQuantity() {
        return quantity;
    }

    public Vehicle(double quantity, double consumption) {
        this.setQuantity(quantity);


        if(this.getClass().getSimpleName().equals("Car")){
            this.setDEFAULT_CONSUPTION_SUMMER(0.9);

        } else {
            this.setDEFAULT_CONSUPTION_SUMMER( 1.6);
        }

        this.setConsumption(consumption);
    }

    private double getDEFAULT_CONSUPTION_SUMMER() {
        return DEFAULT_CONSUPTION_SUMMER;
    }

    private void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption + getDEFAULT_CONSUPTION_SUMMER();
    }


    private double getConsumption() {
        return consumption ;
    }

    private void setDEFAULT_CONSUPTION_SUMMER(double DEFAULT_CONSUPTION_SUMMER) {
        this.DEFAULT_CONSUPTION_SUMMER = DEFAULT_CONSUPTION_SUMMER;
    }

    public void refuel(double fuel){

       if(this.getClass().getSimpleName().equals("Truck")){

           fuel = fuel * 0.95;

       }

        this.quantity += fuel;
    }


    public void drive(double distance){

        if(distance * this.getConsumption() > this.getQuantity() ){

            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }


        this.setQuantity(getQuantity() - distance * this.getConsumption());

        DecimalFormat df = new DecimalFormat("#.## km");
        System.out.println(this.getClass().getSimpleName() + " travelled " + df.format(distance));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + String.format("%.2f", this.quantity);
    }
}
