import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String data = scanner.nextLine();
        while(!(data.equals("search"))){

            String[] phoneData = data.split("-");

            String name = phoneData[0];
            String phone = phoneData[1];

            if(phonebook.containsKey(name)){
                phonebook.replace(name, phone);
            } else {
                phonebook.put(name, phone);
            }

            data = scanner.nextLine();
        }

        data = scanner.nextLine();
        while (!data.equals("stop")) {



            String name = data;

            if (phonebook.containsKey(name)) {

                for(Map.Entry<String, String> entry : phonebook.entrySet()){

                    if (entry.getKey().equals(name)) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }

            } else {
                System.out.println("Contact " + name +" does not exist.");
            }

            data = scanner.nextLine();
        }

    }
}
