package MordorsCrueltyPlan;


public class Happiness {

    private int pointOfHappines;


    public void addFood(String food) {

        switch (food) {

            case "cram":
                this.pointOfHappines += 2;
                break;
            case "lembas":
                this.pointOfHappines += 3;
                break;
            case "apple":
                this.pointOfHappines += 1;
                break;
            case "melon":
                this.pointOfHappines += 1;
                break;
            case "honeycake":
                this.pointOfHappines += 5;
                break;
            case "mushrooms":
                this.pointOfHappines += -10;
                break;
            default:
                this.pointOfHappines += -1;
                break;

        }

    }

    private String getMood() {

        if (pointOfHappines < -5) {

            return "Angry";
        } else if ( pointOfHappines < 0) {

            return "Sad";
        } else if (pointOfHappines <= 15) {

            return "Happy";
        } else {
            return "JavaScript";
        }
    }

    @Override
    public String toString() {
        return this.pointOfHappines + "\n" + getMood();
    }
}
