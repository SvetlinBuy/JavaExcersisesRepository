package MultipleImplementation;

public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private Integer age;
    private String id;
    private String birthDate;



    public Citizen(String name, int age, String id, String birthDate) {

        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getBirthdate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
