package Mankind;

public class Student extends Human {

    private String facultyNumber;



    public Student(String firstName, String lasttName, String facultyNumber) {
        super(firstName, lasttName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultynumber) {

        if(facultynumber.length() < 5 || facultynumber.length() > 10){

            throw new IllegalArgumentException("Invalid faculty number!");
        }


        this.facultyNumber = facultynumber;
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString() {
        return "First Name: "+ super.getFirstName()
                + "\nLast Name: " + super.getLastName()
                +"\nFaculty number: " + getFacultyNumber();
    }
}
