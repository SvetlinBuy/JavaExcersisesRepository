package MilitaryElite;

import MilitaryElite.Intefaces.IEngineer;

import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {


    private List<Repair> repairs;


    @Override
    public List<Repair> getRepairs() {
        return repairs;
    }

    private void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public Engineer(String id, String firstName, String lastName, Double salary, String corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Repair r:repairs) {

            sb.append("\n");
            sb.append("  "+r.toString());

        }

        return "Name: "+this.getFirstName()+" "+this.getLastName()+" Id: "+this.getId()+" Salary: "+String.format("%.2f", this.getSalary())+"\n" +
                "Corps: "+ this.getCorps()+"\n" +
                "Repairs:" + sb.toString();
    }
}
