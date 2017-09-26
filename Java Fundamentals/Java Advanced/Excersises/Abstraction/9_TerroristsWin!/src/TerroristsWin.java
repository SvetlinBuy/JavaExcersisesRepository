import java.util.Scanner;

public class TerroristsWin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        int bombEndIndex = 0;
        int bombStartIndex = 0;

        while (true){
            boolean bombFound = false;
            String bomb = "";
            int bombPower = 0;
            for (int i = 0; i < input.length; i++) {
                if(input[i] == '|'){
                    bombFound = true;
                    if (bomb.equals("")){
                        bombStartIndex = i;
                    }
                }

                if (bombFound){
                    bomb +=input[i];
                    if (!bomb.equals("|") && input[i] == '|'){
                        bombEndIndex = i;
                        break;
                    }
                }
            }

            for (int i = 1; i < bomb.length()-1; i++) {
                char temp = bomb.charAt(i);
                bombPower += (int) temp;
            }

            bombPower = bombPower % 10;
            int bombStartrange = bombStartIndex-bombPower;
            int bombEndRange = bombEndIndex + bombPower;
            String bombReplace = "";

            if (bombStartrange < 0 ){
                bombStartrange = 0;
            }
            else if (bombEndRange > input.length-1){
                bombEndRange = input.length-1;
            }


            for (int i = bombStartrange; i <= bombEndRange; i++) {
                input[i] = '.';

            }
            if (!bombFound){
                break;
            }
        }

        System.out.println(input);
    }
}
