package MilitaryElite;

import MilitaryElite.Intefaces.ISoldier;
import javafx.collections.transformation.SortedList;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Private> garnison = new ArrayList<>();


        String command = scanner.nextLine();

        while(!command.equals("End")){

            String[] com = command.split(" ");

            String type = com[0];
            String id = com[1];
            String firstName = com[2];
            String lastName = com[3];
            String salary = com[4];



            switch (type){

                case "Private": createPrivate(id,firstName,lastName,salary, garnison);break;
                case "Commando": createCommando(id,firstName,lastName,salary, com); break;
                case "Engineer": createEngineer(id,firstName,lastName,salary, com); break;
                case "LeutenantGeneral": createLeutenantGeneral(id,firstName,lastName,salary, com, garnison);break;
                case "Spy": createSpy(id,firstName,lastName,com[4]);break;

            }

            command = scanner.nextLine();
        }

    }

    private static void createSpy(String id, String firstName, String lastName, String codeNumber) {

        ISoldier spy = new Spy(id,firstName,lastName,codeNumber);

        System.out.println(spy.toString());

    }

    private static void createLeutenantGeneral(String id, String firstName, String lastName, String salary, String[] com, List<Private> garnison) {

        List<Private> GeneralList = new LinkedList<>();

        Comparator cmp = Collections.reverseOrder();

        Collections.sort(GeneralList, cmp);

        for (int i = 5; i < com.length; i++) {

            for (Private p:garnison) {

                if(p.getId().equals(com[i])){

                    GeneralList.add(p);
                }
            }

        }


        LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, Double.parseDouble(salary), GeneralList);

        System.out.println(leutenantGeneral.toString());

    }

    private static void createEngineer(String id, String firstName, String lastName, String salary, String[] com) {

        String corps = com[5];

        List<Repair> repairs = new ArrayList<>();

        for (int i = 6; i < com.length -1; i+=2) {

            Repair rep = new Repair(com[i], Integer.parseInt(com[i+1]));

            repairs.add(rep);
        }

        Engineer engineer = new Engineer(id, firstName, lastName, Double.parseDouble(salary),corps, repairs);

        System.out.println(engineer.toString());

    }

    private static void createCommando(String id, String firstName, String lastName, String salary, String[] com) {

        String corps = com[5];

        List<Mission> missionsList = new ArrayList<>();

        for (int i = 6; i < com.length -1 ; i+=2) {

            String missionName = com[i];
            String missionState = com[i+1];


            if(!missionState.equals("inProgress") && !missionState.equals("Finished")){

                continue;
            }

            Mission mis = new Mission(missionName, missionState);

            missionsList.add(mis);
        }

        Commando commando = new Commando(id, firstName,lastName,Double.parseDouble(salary), corps, missionsList);

        System.out.println(commando.toString());

    }

    private static void createPrivate(String id, String firstName, String lastName, String salary, List<Private> garnison) {

        Private newPrivate = new Private(id,firstName,lastName,Double.parseDouble(salary));
        
        garnison.add(newPrivate);

        System.out.println(newPrivate.toString());

    }
}




