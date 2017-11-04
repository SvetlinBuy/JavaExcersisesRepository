package FragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;

public class Animal {

    protected ArrayList<Food> foodEaten;

    public Animal(ArrayList<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food food){

        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods){

        for (Food food:foods) {

            eat(food);
        }

    }
}
