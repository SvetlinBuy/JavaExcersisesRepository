package MilitaryElite;

import MilitaryElite.Intefaces.ICommando;

import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando{


    private List<Mission> missionList;


    public List<Mission> getMissionList() {
        return missionList;
    }

    private void setMissionList(List<Mission> missionList) {
        this.missionList = missionList;
    }

    public Commando(String id, String firstName, String lastName, Double salary, String corps, List<Mission> missionList) {
        super(id, firstName, lastName, salary, corps);

        this.setMissionList(missionList);

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Mission m:missionList) {

            sb.append("\n");
            sb.append("  "+ m.toString());

        }

        return "Name: "+this.getFirstName()+" "+this.getLastName()+" Id: "+this.getId()+" Salary: "+String.format("%.2f", this.getSalary())+"\n" +
                "Corps: "+this.getCorps()+"\n" +
                "Missions:" + sb.toString();
    }
}
