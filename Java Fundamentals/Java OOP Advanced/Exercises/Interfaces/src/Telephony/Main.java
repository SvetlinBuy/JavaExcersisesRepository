package Telephony;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] phoneNumbers = scanner.nextLine().split(" ");

        String[] websites = scanner.nextLine().split(" ");

        cellPhone smartphone = new Smartphone();


        for (String phoneNumber : phoneNumbers) {


                smartphone.call(phoneNumber);



        }


        for (String website : websites) {

                smartphone.browse(website);


        }

    }
}
