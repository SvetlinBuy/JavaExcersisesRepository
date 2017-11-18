package MilitaryElite;

import MilitaryElite.Intefaces.IRepair;

public class Repair implements IRepair {


    private String repairPart;
    private Integer repairHours;

    public Repair(String repairPart, Integer repairHours) {
        this.setRepairPart(repairPart);
        this.setRepairHours(repairHours);
    }

    public String getRepairPart() {
        return repairPart;
    }

    private void setRepairPart(String repairPart) {
        this.repairPart = repairPart;
    }

    public Integer getRepairHours() {
        return repairHours;
    }

    private void setRepairHours(Integer repairHours) {
        this.repairHours = repairHours;
    }

    @Override
    public String toString() {
        return "Part Name: "+this.getRepairPart()+" Hours Worked: "+this.getRepairHours();
    }
}
