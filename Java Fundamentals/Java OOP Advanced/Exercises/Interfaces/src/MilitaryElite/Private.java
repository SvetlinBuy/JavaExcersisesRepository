package MilitaryElite;

import MilitaryElite.Intefaces.IPrivate;

public class Private extends Soldier implements IPrivate {

    private Double salary;

    Private(String id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    public Double getSalary() {
        return salary;
    }

    private void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: "+this.getFirstName()+" "+this.getLastName()+" Id: "+this.getId()+" Salary: " + String.format("%.2f", this.getSalary());
    }
}
