package BorderControl;

public class Citizen implements Unknown{

    private String name;
    private Integer age;
    private String id;

    public Citizen(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }


}
