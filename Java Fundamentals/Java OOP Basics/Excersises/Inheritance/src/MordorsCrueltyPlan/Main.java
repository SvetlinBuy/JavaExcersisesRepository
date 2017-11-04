package MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Happiness happiness = new Happiness();

        String[] food = reader.readLine().split(" ");

        for (String f : food) {

            happiness.addFood(f.toLowerCase());
        }


        System.out.println(happiness);
    }
}
