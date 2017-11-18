package FirstAndReverseTeam;

public class Person {

    private String firstName;
    private String lastName;
    private Double salary;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public Person(String firstName, String lastName, Integer age, Double salary) {
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

    private void setSalary(Double salary) {
        this.salary = salary;
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



