package WildFarm;

import static WildFarm.Main.DECIMAL_FORMAT;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(), super.getAnimalName(), DECIMAL_FORMAT.format(super.getAnimalWeight() ), this.getLivingRegion(), super.getFoodEaten());
    }
}
