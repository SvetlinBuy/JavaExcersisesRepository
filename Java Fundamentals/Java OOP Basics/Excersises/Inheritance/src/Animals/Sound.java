package Animals;

public class Sound {


    public String produceSound(String animal) {

        String str = "";

        switch (animal) {

            case "class Animals.Dog":
                str = "BauBau";
                break;
            case "class Animals.Cat":
                str = "MiauMiau";
                break;
            case "class Animals.Kitten":
                str = "Miau";
                break;
            case "class Animals.Tomcat":
                str = "Give me one million b***h";
                break;
            case "class Animals.Frog":
                str = "Frogggg";
                break;
            case "class Animals.Animal":
                str = "Not implemented!";
                break;

        }

        return str;
    }

}
