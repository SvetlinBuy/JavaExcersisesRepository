package Mankind;

public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lasttName, double weekSalary, double workHoursPerDay) {
        super(firstName, lasttName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {


        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {

        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.workHoursPerDay = workHoursPerDay;
    }


    @Override
    protected void setLastName(String lastName) throws IllegalArgumentException{

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }

        super.setLastName(lastName);
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    private double getSalaryPerHour() {


        return getWeekSalary() / (getWorkHoursPerDay() * 7);

    }

    @Override
    public String toString() {
        return "\nFirst Name: " + super.getFirstName()
                + "\nLast Name: " + super.getLastName()
                + "\nWeek Salary: " + String.format("%.2f", getWeekSalary())
                + "\nHours per day: " + String.format("%.2f", getWorkHoursPerDay())
                + "\nSalary per hour: " + String.format("%.2f",  getSalaryPerHour());
    }
}
