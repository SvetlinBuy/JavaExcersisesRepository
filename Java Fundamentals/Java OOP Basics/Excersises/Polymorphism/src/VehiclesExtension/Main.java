package VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split(" ");

        double carFuel = Double.parseDouble(carData[1]);
        double carConsumption = Double.parseDouble(carData[2]);
        double carTankCapacity = Double.parseDouble(carData[3]);

        String[] truckData = reader.readLine().split(" ");

        double truckFuel = Double.parseDouble(truckData[1]);
        double truckConsumption = Double.parseDouble(truckData[2]);
        double truckTankCapacity = Double.parseDouble(carData[3]);


        String[] busData = reader.readLine().split(" ");

        double busFuel = Double.parseDouble(busData[1]);
        double busConsumption = Double.parseDouble(busData[2]);
        double busTankCapacity = Double.parseDouble(busData[3]);

        Vehicle car = new Car(carFuel, carConsumption, carTankCapacity);
        Vehicle truck = new Truck(truckFuel, truckConsumption, truckTankCapacity);
        Vehicle bus = new Bus(busFuel, busConsumption, busTankCapacity);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            String[] command = reader.readLine().split(" ");

            if (command[0].equals("Drive")) {

                try{
                if (command[1].equals("Car")) {

                    car.drive(Double.parseDouble(command[2]));

                } else if(command[1].equals("Truck")) {
                    truck.drive(Double.parseDouble(command[2]));
                } else {
                    bus.drive(Double.parseDouble(command[2]));
                }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            } else if (command[0].equals("Refuel")){

                try{
                if (command[1].equals("Car")) {

                    car.refuel(Double.parseDouble(command[2]));

                } else if (command[1].equals("Truck")){
                    truck.refuel(Double.parseDouble(command[2]));
                } else {
                    bus.refuel(Double.parseDouble(command[2]));
                }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            } else {

                if(command[0].equals("DriveEmpty")){

                    try{

                        if(command[1].equals("Bus")){


                            bus.driveEmpty(Double.parseDouble(command[2]));
                        }

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }


                }

            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
