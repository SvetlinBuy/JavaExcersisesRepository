package DPC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<String, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String commands = scanner.nextLine();


        while (!commands.equalsIgnoreCase("end")) {

            String[] comArgs = commands.split(" ");

            String comType = comArgs[0];

            switch (comType) {


                case "Create":
                    createAccount();
                    break;
                case "Deposit":
                    deposit(comArgs[1], comArgs[2]);
                    break;
                case "SetInterest":
                    setInterest(comArgs[1]);
                    break;
                case "GetInterest":
                    getInterest(comArgs[1], comArgs[2]);
                    break;

            }


            commands = scanner.nextLine();
        }
    }

    private static void getInterest(String id, String years) {

        String rid = "ID" + id;
        int y = Integer.valueOf(years);


        if (bankAccounts.containsKey(rid)) {


            System.out.printf("%.2f",bankAccounts.get(rid).getInterest(y));
            System.out.println();

        } else {
            System.out.println("Account does not exist");
        }

    }

    private static void setInterest(String comArg) {

        for (Map.Entry<String, BankAccount> ba: bankAccounts.entrySet()) {

            ba.getValue().setInterest(Double.valueOf(comArg));

        }
    }

    private static void deposit(String id, String amount) {

        String rid = "ID" + id;
        double am = Double.valueOf(amount);

       if(bankAccounts.containsKey(rid)){


           bankAccounts.get(rid).deposit(am);

           System.out.println("Deposited " + (int) am +" to " + rid);

       } else {
           System.out.println("Account does not exist");
       }

    }

    private static void createAccount() {

        BankAccount account = new BankAccount();

        bankAccounts.put(account.toString(), account);

        System.out.println("Account "+ account.toString() + " created");
    }
}

