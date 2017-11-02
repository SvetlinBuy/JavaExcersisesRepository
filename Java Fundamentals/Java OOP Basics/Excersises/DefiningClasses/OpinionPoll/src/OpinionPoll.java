import java.util.*;

public class OpinionPoll {

    public static void main(String[] args) {


        List<Person> listPersons = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] personData = scanner.nextLine().split(" ");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person newPerson = new Person(name, age);

            listPersons.add(newPerson);

        }

        Map<String, Integer> sortedNames= new TreeMap<>();

        for (Person p: listPersons) {

            if (p.getAge() > 30) {

                sortedNames.put(p.getName(), p.getAge());

            }
        }


        for (Map.Entry<String, Integer> person: sortedNames.entrySet()) {

            System.out.println(person.getKey() + " - " +person.getValue());

        }
    }
}


class Person {

    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {

        this.name = "No name";
        this.age = 1;
    }

    public Person(int age) {
        this();
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}