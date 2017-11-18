package MilitaryElite;

import MilitaryElite.Intefaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {


    private String corps;

    public String getCorps() {
        return corps;
    }

    private void setCorps(String corps) {


            this.corps = corps;

    }

    SpecialisedSoldier(String id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }
}
