package ShopingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Product> listProducts = new ArrayList<>();

        List<Person> listPersons = new LinkedList<>();

        String[] personsToAdd = reader.readLine().split(";");

        for (String pdata : personsToAdd) {

            String name = pdata.split("=")[0];
            double money = Double.parseDouble(pdata.split("=")[1]);

            try {

                Person person = new Person(name, money);
                listPersons.add(person);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        String[] productsToAdd = reader.readLine().split(";");

        for (String prodData : productsToAdd) {

            String name = prodData.split("=")[0];
            double cost = Double.parseDouble(prodData.split("=")[1]);

            try {

                Product product = new Product(name, cost);
                listProducts.add(product);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        String order = reader.readLine();

        while (!order.equals("END")) {

            String customerName = order.split("\\s+")[0];
            String productName = order.split("\\s+")[1];

            for (Person p : listPersons) {
                if (p.getName().equals(customerName)) {
                    for (Product prod : listProducts) {
                        if (prod.getName().equals(productName)) {

                            try {
                                p.buyProduct(prod);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
            order = reader.readLine();
        }

        for (Person person: listPersons) {

            String bagContent = "";

            if (person.getBag().size() == 0) {

                bagContent = "Nothing bought";

            } else {

                StringJoiner sj = new StringJoiner(", ");



                for (Product product: person.getBag()) {


                    sj.add(product.getName());


                }

                 bagContent = sj.toString();
            }



            System.out.println(person.getName() +" - " + bagContent);


        }

    }
}
