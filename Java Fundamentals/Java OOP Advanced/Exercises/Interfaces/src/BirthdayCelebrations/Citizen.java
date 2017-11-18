package BirthdayCelebrations;

public class Citizen implements Unknown, BirthDate {

    private String name;
    private Integer age;
    private String id;
    private String birthDate;


    public Citizen(String name, Integer age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public Citizen(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }


    @Override
    public String getDate() {
        return this.birthDate;
    }
}
