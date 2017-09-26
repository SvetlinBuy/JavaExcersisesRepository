import java.util.*;

public class VehiclePark {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<String> ListCars = new ArrayList<String>(Arrays.asList(input.nextLine().split(" ")));


        String commands = input.nextLine();

        int vehiclesSold= 0;

        while (!commands.equals("End of customers!")) {

            String vehicleType = commands.split(" ")[0];
            String numberOfSeats = commands.split(" ")[2];

            String request = "";

            if (vehicleType.equals("Car") ||vehicleType.equals("Van")  || vehicleType.equals("Bus")  ) {

                request = (vehicleType.charAt(0) + numberOfSeats).toLowerCase();

            }  else {
                continue;
            }

            if (ListCars.contains(request)) {

                int price = request.charAt(0) * Integer.parseInt(numberOfSeats);

                System.out.printf("Yes, sold for %d$%n", price);

                ListCars.remove(request);

                vehiclesSold++;

            } else {
                System.out.println("No");
            }

            commands = input.nextLine();
        }

        StringJoiner joiner= new StringJoiner(", ");

        for (int i = 0; i < ListCars.size() ; i++) {

            joiner.add(ListCars.get(i));

        }

        System.out.printf("Vehicles left: %s%n",  joiner);
        System.out.printf("Vehicles sold: %d", vehiclesSold);

    }

}
