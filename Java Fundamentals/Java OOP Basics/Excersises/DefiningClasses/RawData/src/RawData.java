import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RawData {

    public static void main(String[] args) throws IOException {

        Map<String, Car> listCars = new LinkedHashMap<>();

        // Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {


            String[] carData = reader.readLine().split(" ");

            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);
            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);
            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            listCars.put(model, car);

        }


        String command = reader.readLine();

        if (command.equals("fragile")) {

            printFragile(listCars);

        } else if(command.equals("flamable")) {

            printFlamable(listCars);

        }
    }

    private static void printFlamable(Map<String, Car> listCars) {

        for (Map.Entry<String, Car> c: listCars.entrySet()) {

            Car car = c.getValue();

            if(car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250){

                System.out.println(car.getModel());
            }
        }


    }

    private static void printFragile(Map<String, Car> listCars) {


        for (Map.Entry<String, Car> c: listCars.entrySet()) {

            Car car = c.getValue();



            if(car.getCargo().getType().equals("fragile") && car.getListTires().stream().anyMatch(x -> x.getPressure() < 1)){

                System.out.println(car.getModel());

            }
        }
    }
}

class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> listTires;

    public Car(
            String model,
            int engineSpeed,
            int enginePower,
            int cargoWeight,
            String cargoType,
            double tire1pressure,
            int tire1age,
            double tire2pressure,
            int tire2age,
            double tire3pressure,
            int tire3age,
            double tire4pressure,
            int tire4age
    ) {
        this.model = model;

        Engine engine = new Engine();
        engine.setSpeed(engineSpeed);
        engine.setPower(enginePower);

        this.engine = engine;

        Cargo cargo = new Cargo();
        cargo.setWeight(cargoWeight);
        cargo.setType(cargoType);

        this.cargo = cargo;

        List<Tire> tireList = new ArrayList<>();

        Tire tire1 = new Tire();
        tire1.setPressure(tire1pressure);
        tire1.setAge(tire1age);
        tireList.add(tire1);

        Tire tire2 = new Tire();
        tire2.setPressure(tire2pressure);
        tire2.setAge(tire2age);
        tireList.add(tire2);

        Tire tire3 = new Tire();
        tire3.setPressure(tire3pressure);
        tire3.setAge(tire3age);
        tireList.add(tire3);

        Tire tire4 = new Tire();
        tire4.setPressure(tire4pressure);
        tire1.setAge(tire4age);
        tireList.add(tire4);


        this.listTires = tireList;
    }

    public double averagePressure(List<Tire> listTires) {

        OptionalDouble averagePressure = listTires.stream().mapToDouble(x -> x.getPressure()).average();

        double trash = Double.parseDouble(averagePressure.toString().substring(15, averagePressure.toString().length() - 1));

        return trash;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getListTires() {
        return listTires;
    }

    public void setListTires(List<Tire> listTires) {
        this.listTires = listTires;
    }

    class Engine {

        private int speed;
        private int power;

        public Engine() {
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }
    }

    class Cargo {

        private int weight;
        private String type;

        public Cargo() {
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    class Tire {

        private double pressure;
        private int age;

        public Tire() {
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}