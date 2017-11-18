package BirthdayCelebrations;


public class Pet implements BirthDate {

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getDate() {
        return this.birthDate;
    }
}
