package DC;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while(!command.equalsIgnoreCase("End")){

            String[] cmdArgs = command.split(" ");

            String cmdType = cmdArgs[0];

            switch (cmdType){

                case "Create": execCreate(cmdArgs, accounts); break;
                case "Deposit": execDeposit(cmdArgs, accounts); break;
                case "Withdraw": execWithdraw(cmdArgs, accounts); break;
                case "Print": execPrint(cmdArgs, accounts); break;
            }

            command = scanner.nextLine();
        }

    }

    private static void execPrint(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {

        int id = Integer.valueOf(cmdArgs[1]);
        BankAccount currentAccount = accounts.get(id);

        if (accounts.containsKey(id)) {

            System.out.println(currentAccount);

        } else {
            System.out.println("Account does not exist");
        }

    }

    private static void execWithdraw(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {

        int id = Integer.valueOf(cmdArgs[1]);
        Double amount = Double.valueOf(cmdArgs[2]);

        if (accounts.containsKey(id)) {
            accounts.get(id).withdraw(amount);
        } else {
            System.out.println("Account does not exist");
        }

    }

    private static void execDeposit(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {

        int id = Integer.valueOf(cmdArgs[1]);
        Double amount = Double.valueOf(cmdArgs[2]);

        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amount);
        } else {
            System.out.println("Account does not exist");
        }


    }

    private static void execCreate(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {


        int id = Integer.valueOf(cmdArgs[1]);
        if (accounts.containsKey(id)) {

            System.out.println("Account already exists");

        } else {
            BankAccount account = new BankAccount(id);

            accounts.put(id, account);
        }

    }
}
