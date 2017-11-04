package Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String command = reader.readLine();

        while (!command.equals("Beast!")) {

            String[] animalProperty = reader.readLine().split(" ");
            String name = animalProperty[0];
            int age = Integer.parseInt(animalProperty[1]);
            String gender = animalProperty[2];

            try {
                switch (command) {

                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(command + "\n" + name + " " + age + " " + gender);
                        dog.produceSound();
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(command + "\n" + name + " " + age + " " + gender);
                        frog.produceSound();
                        break;
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(command + "\n" + name + " " + age + " " + gender);
                        cat.produceSound();
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age, gender);
                        System.out.println(command + "\n" + name + " " + age + " " + gender);
                        kitten.produceSound();
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age, gender);
                        System.out.println(command + "\n" + name + " " + age + " " + gender);
                        tomcat.produceSound();
                        break;
                        default: System.out.println("Invalid input!");break;


                }
            }catch( IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            command = reader.readLine();
        }


    }


}
