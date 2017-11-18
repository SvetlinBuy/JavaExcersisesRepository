import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CarSalesman {

    public static void main(String[] args)throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(reader.readLine());

        HashMap<String, Engine> cars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            Engine engine = null;

            String engineModel = tokens[0];
            Integer power = Integer.parseInt(tokens[1]);

            engine = getEngine(tokens, engine, engineModel, power);

            cars.put(engineModel, engine);
        }

        Integer m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            Car car = null;

            car = getCar(cars, tokens, car);

            System.out.println(car);
        }
    }

    private static Engine getEngine(String[] tokens, Engine engine, String engineModel, Integer power) {
        switch (tokens.length) {
            case 2:
                engine = new Engine(engineModel, power);
                break;
            case 3:
                try {
                    Integer displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(engineModel, power, displacement);
                } catch (Exception e) {
                    String efficiency = tokens[2];
                    engine = new Engine(engineModel, power, efficiency);
                }

                break;
            case 4:
                Integer displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(engineModel, power, displacement, efficiency);
                break;
        }
        return engine;
    }

    private static Car getCar(HashMap<String, Engine> cars, String[] tokens, Car car) {
        String carModel = tokens[0];
        Engine engine = cars.get(tokens[1]);

        switch (tokens.length) {
            case 2:
                car = new Car(carModel, engine);
                break;
            case 3:
                try {
                    Integer weight = Integer.parseInt(tokens[2]);
                    car = new Car(carModel, engine, weight);
                } catch (Exception e) {
                    String color = tokens[2];
                    car = new Car(carModel, engine, color);
                }
                break;
            case 4:
                Integer weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(carModel, engine, weight, color);
                break;
        }
        return car;
    }
}

class Engine {
    private final static String DEFAULT_EFFICIENCY = "n/a";
    private final static String DEFAULT_DISPLACEMENT = "n/a";

    private String engineModel;
    private Integer power;
    private String displacement;
    private String efficiency;


    public Engine(String engineModel, Integer power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public Engine(String engineModel, Integer power, Integer displacement) {
        this(engineModel, power);
        this.displacement = String.valueOf(displacement);
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public Engine(String engineModel, Integer power, String efficiency) {
        this(engineModel, power);
        this.efficiency = efficiency;
        this.displacement = DEFAULT_DISPLACEMENT;
    }

    public Engine(String engineModel, Integer power, Integer displacement, String efficiency) {
        this(engineModel, power, efficiency);
        this.displacement = String.valueOf(displacement);
    }



    public static String getDefaultEfficiency() {
        return DEFAULT_EFFICIENCY;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public Integer getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}

class Car {
    private final static String DEFAULT_WEIGHT = "n/a";
    private final static String DEFAULT_COLOR = "n/a";

    private String carModel;
    private Engine engine;
    private String weight;
    private String colors;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.colors = DEFAULT_COLOR;
    }

    public Car(String carModel, Engine engine, String colors) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.colors = colors;
    }

    public Car(String carModel, Engine engine, Integer weight) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = String.valueOf(weight);
        this.colors = DEFAULT_COLOR;
    }

    public Car(String carModel, Engine engine, Integer weight, String colors) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = String.valueOf(weight);
        this.colors = colors;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getColors() {
        return this.colors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(carModel + ":\n");
        sb.append("  " + getEngine().getEngineModel() + ":" + "\n");
        sb.append("    Power: " + getEngine().getPower() + "\n");
        sb.append("    Displacement: " + getEngine().getDisplacement() + "\n");
        sb.append("    Efficiency: " + getEngine().getEfficiency() + "\n");
        sb.append("  Weight: " + weight + "\n");
        sb.append("  Color: " + colors);
        return sb.toString();
    }
}

