public class TotheStars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] star1 = scanner.nextLine().split(" ");
        String[] star2 = scanner.nextLine().split(" ");
        String[] star3 = scanner.nextLine().split(" ");

        String[] startCoordinates = scanner.nextLine().split(" ");

        double currentX = Double.parseDouble(startCoordinates[0]);
        double currentY = Double.parseDouble(startCoordinates[1]);

        int steps = Integer.parseInt(scanner.nextLine());

        String star1Name = star1[0].toLowerCase();
        String star2Name = star2[0].toLowerCase();
        String star3Name = star3[0].toLowerCase();

        while (steps >= 0){

            if (chechIfInOrbit( star1, currentX, currentY)) {
                System.out.println(star1Name);
            }else  if (chechIfInOrbit( star2, currentX, currentY)){
                System.out.println(star2Name);
            }else if (chechIfInOrbit( star3, currentX, currentY)){
                System.out.println(star3Name);
            }else {
                System.out.println("space");
            }

            currentY++;
            steps--;
        }
    }

    private static boolean chechIfInOrbit(String[] star, double currentX, double currentY) {
        double starX = Double.parseDouble((star[1]));
        double starY = Double.parseDouble(star[2]);

        if (currentX >= starX-1 && currentX <= starX +1 && currentY >= starY-1 && currentY <= starY+1) {
            return true;
        }
        else{
            return false;
        }

    }
}
