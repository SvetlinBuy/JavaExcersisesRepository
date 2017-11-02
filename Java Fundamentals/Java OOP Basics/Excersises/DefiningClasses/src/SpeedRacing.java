import java.util.*;

public class SpeedRacing {

    public static void main(String[] args) {

        Set<Car> cars = new LinkedHashSet<>();

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[]carProperties = scanner.nextLine().split(" ");

            String model = carProperties[0];
            double fuelAmount = Integer.parseInt(carProperties[1]);
            double fuelPerKM = Double.parseDouble(carProperties[2]);

            Car newCar = new Car();

            newCar.setModel(model);
            newCar.setFuelAmount(fuelAmount);
            newCar.setFuelPerKm(fuelPerKM);

            cars.add(newCar);

        }

        String commands = scanner.nextLine();

        while (!commands.equals("End")) {

            String[] comArgs = commands.split(" ");

            String model = comArgs[1];
            int driveDistance = Integer.parseInt(comArgs[2]);


            for (Car c: cars) {

                if(c.getModel().equals(model)){

                    if(c.isFuelEnough(driveDistance)){

                        System.out.println("Insufficient fuel for the drive");

                    } else {

                        c.setFuelAmount(c.getFuelAmount()-(driveDistance * c.getFuelPerKm()));
                        c.setDistanceTraveled(c.getDistanceTraveled()+driveDistance);

                    }
                }
            }


            commands = scanner.nextLine();
        }


        for (Car c: cars) {

            System.out.printf("%s %.2f %d", c.getModel(), c.getFuelAmount(), c.getDistanceTraveled());
            System.out.println();

        }


    }
}

class Car {


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    private String model;
    private double fuelAmount;
    private  double fuelPerKm;
    private  int distanceTraveled;


    public Car() {

        this.distanceTraveled = 0;
    }

    public boolean isFuelEnough(int amountKM){

        double fuel = this.fuelAmount;
        double fuelPerKM = this.fuelPerKm;

        double availableKMs = fuel / fuelPerKM;

        if(amountKM <= availableKMs){

            return false;
        }

        return true;

    }


}
