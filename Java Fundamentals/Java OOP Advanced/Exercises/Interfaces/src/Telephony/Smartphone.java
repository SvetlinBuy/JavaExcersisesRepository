package Telephony;

public class Smartphone implements cellPhone{


    @Override
    public void call( String phoneNumber) {

        String[] phoneNumberArr = phoneNumber.split("");

        boolean checker = false;

        for (String p:phoneNumberArr) {

            if(!Character.isDigit( p.charAt(0))){

                checker = true;

            }

        }

        if(checker){
            System.out.println("Invalid number!");
        } else {

            System.out.println("Calling... " + phoneNumber);

        }

    }

    @Override
    public void browse(String website) {

        if(website.isEmpty()){
            System.out.println("Browsing: " + website + "!");
        } else {

            String[] websiteArr = website.split("");

            boolean checker = false;

            for (String s:websiteArr) {

                if(Character.isDigit( s.charAt(0))){

                    checker = true;

                }

            }

            if(checker){
                System.out.println("Invalid URL!");
            } else {
                System.out.println("Browsing: " + website + "!");
            }

        }


    }
}
