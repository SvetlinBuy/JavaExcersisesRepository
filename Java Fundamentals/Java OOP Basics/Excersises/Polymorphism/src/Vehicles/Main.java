package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split(" ");

        double carFuel = Double.parseDouble(carData[1]);
        double carConsumption = Double.parseDouble(carData[2]);

        String[] truckData = reader.readLine().split(" ");

        double truckFuel = Double.parseDouble(truckData[1]);
        double truckConsumption = Double.parseDouble(truckData[2]);

        Vehicle car = new Car(carFuel, carConsumption);
        Vehicle truck = new Truck(truckFuel, truckConsumption);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            String[] command = reader.readLine().split(" ");

            if (command[0].equals("Drive")) {

                try{
                if (command[1].equals("Car")) {

                    car.drive(Double.parseDouble(command[2]));

                } else {
                    truck.drive(Double.parseDouble(command[2]));
                }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            } else {

                try{
                if (command[1].equals("Car")) {

                    car.refuel(Double.parseDouble(command[2]));

                } else {
                    truck.refuel(Double.parseDouble(command[2]));
                }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
