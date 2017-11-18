package Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {

        if (name.isEmpty() || gender.isEmpty() || age < 0) {

            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void produceSound() {

        System.out.println(new Sound().produceSound(this.getClass().toString()));
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.gender;
    }
}
