import java.util.*;
import java.util.stream.Collectors;

public class CompanyRoster {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Departament> departments = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] employeeData = scanner.nextLine().split(" ");
            Employee newEmployee = new Employee();

            fillEmployeeData(employeeData, newEmployee);

            fillDepartmanetsList(employeeData, newEmployee, departments);

        }

        Map<String, Double> hightestSalarySortedDeps = new TreeMap<>(Collections.reverseOrder());

        for (Departament d : departments) {

            String trash = d.getAverageSalary().toString().substring(15,  d.getAverageSalary().toString().length()-1);

            hightestSalarySortedDeps.put(d.getDepartamentName(), Double.parseDouble(trash));

        }


        hightestSalarySortedDeps = sortByValue(hightestSalarySortedDeps);

        String hsalaryDepartment = hightestSalarySortedDeps.keySet().iterator().next();

        System.out.println("Highest Average Salary: " + hsalaryDepartment);

        for (Departament d2: departments) {


            if(d2.getDepartamentName().equals(hsalaryDepartment)){

                List<Employee> empl = d2.getEmployeeList();

              Collections.sort(empl, Comparator.comparingDouble(Employee::getSalary).reversed());

                for (Employee e: empl) {

                    System.out.printf("%s %.2f %s %d", e.getName(), e.getSalary(), e.getEmail(), e.getAge());
                    System.out.println();

                }

            }

        }

    }


    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private static void fillDepartmanetsList(String[] employeeData, Employee newEmployee, List<Departament> departments) {
        String departament = employeeData[3];

        Departament newDepartament = new Departament(departament, new ArrayList<>());

        if (departments.size() > 0){

            boolean checker = true;

            for (Departament d : departments) {


                if (d.getDepartamentName().equals(departament)) {

                    d.getEmployeeList().add(newEmployee);
                    checker = false;

                }
            }

            if(checker){
                newDepartament.getEmployeeList().add(newEmployee);

                departments.add(newDepartament);
            }

        } else {

            newDepartament.getEmployeeList().add(newEmployee);

            departments.add(newDepartament);

        }

    }

    private static void fillEmployeeData(String[] employeeData, Employee newEmployee) {

        String name = employeeData[0];
        double salary = Double.parseDouble(employeeData[1]);
        String position = employeeData[2];
        String departament = employeeData[3];

        newEmployee.setName(name);
        newEmployee.setSalary(salary);
        newEmployee.setPosition(position);
        newEmployee.setDepartment(departament);

        if (employeeData.length == 5) {

            if (employeeData[4].contains("@")) {

                newEmployee.setEmail(employeeData[4]);


            } else {
                newEmployee.setAge(Integer.parseInt(employeeData[4]));
            }


        } else if (employeeData.length == 6) {

            String email = employeeData[4];
            int age = Integer.parseInt(employeeData[5]);

            newEmployee.setEmail(email);
            newEmployee.setAge(age);

        }
    }
}


class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee() {

        this.email = "n/a";
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

class Departament {

    private String departamentName;
    private List<Employee> employeeList;

    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Departament(String departamentName, List<Employee> employeeList) {
        this.departamentName = departamentName;
        this.employeeList = employeeList;
    }

    public OptionalDouble getAverageSalary() {


        return employeeList.stream().mapToDouble(x -> x.getSalary()).average();


    }
}
