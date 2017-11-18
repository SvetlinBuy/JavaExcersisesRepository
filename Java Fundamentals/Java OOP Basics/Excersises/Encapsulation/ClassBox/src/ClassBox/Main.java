package ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Double lenght = Double.parseDouble(reader.readLine());
        Double width = Double.parseDouble(reader.readLine());
        Double height = Double.parseDouble(reader.readLine());

        Box box = new Box(lenght, width, height);

        System.out.println("Surface Area - " + String.format("%.2f", box.surfaceArea()));
        System.out.println("Lateral Surface Area - " + String.format("%.2f", box.lateralSurfaceArea()));
        System.out.println("Volume - " + String.format("%.2f", box.volume()));


    }
}
