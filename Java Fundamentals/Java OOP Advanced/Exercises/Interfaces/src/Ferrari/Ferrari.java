package Ferrari;

public class Ferrari implements Car {

    private String driverName;
    private String ferarriModel;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.ferarriModel = "488-Spider";
    }

    @Override
    public String brakes() {

        return "Brakes!";
    }

    @Override
    public String gasPedal() {

        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return this.ferarriModel+"/"+this.brakes()+"/"+this.gasPedal()+"/"+this.driverName;
    }
}
