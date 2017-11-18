package ValidationData;

public class Person {

    private String firstName;
    private String lastName;
    private Double salary;
    private Integer age;


    public Person(String firstName, String lastName, Integer age,  Double salary) {

        if (firstName.length() < 3) {

            throw  new IllegalArgumentException("First name cannot be less than 3 symbols");

        }

        if (age < 1) {

            throw  new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        if (lastName.length() < 3) {

            throw  new IllegalArgumentException("Last name cannot be less than 3 symbols");

        }

        if ( salary < 460 ) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void increaseSalary(int bonus) {

        if(this.age > 30){
            this.salary += this.salary * bonus / 100;
        } else {
            this.salary += this.salary * bonus / 200;
        }

    }

    @Override
    public String toString() {
        return String.format(this.firstName + " " + this.lastName + " gets " + this.getSalary() + " leva");
    }
}



