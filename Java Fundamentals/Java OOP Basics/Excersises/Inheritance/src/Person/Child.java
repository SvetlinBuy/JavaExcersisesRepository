package Person;

public class Child extends Person {

    @Override
    protected void setAge(int age) throws IllegalArgumentException {

        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }

        super.setAge(age);
    }

    public Child(String name, int age) {
        super(name, age);

    }

}
