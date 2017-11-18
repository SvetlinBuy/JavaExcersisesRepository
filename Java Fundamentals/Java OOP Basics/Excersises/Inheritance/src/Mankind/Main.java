package Mankind;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] studentData = scanner.nextLine().split(" ");

        String[] workerData = scanner.nextLine().split(" ");

        try {
            Student student = new Student(studentData[0], studentData[1], studentData[2]);

            Worker worker = new Worker(workerData[0], workerData[1], Double.parseDouble(workerData[2]), Double.parseDouble(workerData[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }





}
