package AnimalFarm;

public class Chicken {


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    private String name;
    private Integer age;

    private void setName(String name) {

        if (name.isEmpty() || name.equals(null) || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(Integer age) {

        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public Chicken(String name, Integer age) {
        this.setName(name);
        this.setAge(age);

    }


    public String eggsPerDay() {

        if (age >= 6 && age < 12) {

            return "1";

        }

        if (age >= 12) {
            return "0.75";
        }

        return "2";
    }
}
