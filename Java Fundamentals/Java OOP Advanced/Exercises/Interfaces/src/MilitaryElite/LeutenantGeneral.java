package MilitaryElite;

import MilitaryElite.Intefaces.ILeutenantGeneral;

import java.util.Collections;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<Private> privates;

    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    private void setPrivates(List<Private> privates) {
        this.privates = privates;
    }

    public LeutenantGeneral(String id, String firstName, String lastName, Double salary, List<Private> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Private p: this.getPrivates()) {

            sb.append("\n");
            sb.append("  "+p.toString());


        }

        return "Name: "+this.getFirstName()+" "+this.getLastName()+" Id: "+this.getId()+" Salary: "+String.format("%.2f", this.getSalary())+"\n" +
                "Privates:" +sb.toString();
    }
}
