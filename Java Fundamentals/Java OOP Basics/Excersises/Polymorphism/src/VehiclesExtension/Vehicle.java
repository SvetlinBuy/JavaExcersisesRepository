package VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double DEFAULT_CONSUPTION_SUMMER;

    private double quantity;
    private double consumption;
    private double tankCapacity;

    Vehicle(double quantity, double consumption, double tankCapacity) {
        this.setQuantity(quantity);


        if(this.getClass().getSimpleName().equals("Car")){
            this.setDEFAULT_CONSUPTION_SUMMER(0.9);

        } else if (this.getClass().getSimpleName().equals("Truck")){
            this.setDEFAULT_CONSUPTION_SUMMER( 1.6);
        } else {
            this.setDEFAULT_CONSUPTION_SUMMER( 1.4);
        }

        this.setConsumption(consumption);
        this.setTankCapacity(tankCapacity);
    }


    private void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption + getDEFAULT_CONSUPTION_SUMMER();
    }


    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private void setDEFAULT_CONSUPTION_SUMMER(double DEFAULT_CONSUPTION_SUMMER) {
        this.DEFAULT_CONSUPTION_SUMMER = DEFAULT_CONSUPTION_SUMMER;
    }

    private double getTankCapacity() {
        return tankCapacity;
    }

    private double getConsumption() {
        return consumption ;
    }


    private double getQuantity() {
        return quantity;
    }

    private double getDEFAULT_CONSUPTION_SUMMER() {
        return DEFAULT_CONSUPTION_SUMMER;
    }


    public void refuel(double fuel){

        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

       if(this.getClass().getSimpleName().equals("Truck")){

           fuel = fuel * 0.95;

       }

       if(fuel + getQuantity() > this.getTankCapacity()){

           throw  new IllegalArgumentException("Cannot fit in tank");
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

    public void driveEmpty(double distance){

        double localConsuption = this.getConsumption() - this.getDEFAULT_CONSUPTION_SUMMER();


        if (distance * localConsuption > this.getQuantity()) {

            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }


        this.setQuantity(getQuantity() - distance * localConsuption);

        DecimalFormat df = new DecimalFormat("#.## km");

    };

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + String.format("%.2f", this.quantity);
    }
}
