package MilitaryElite;

import MilitaryElite.Intefaces.IMission;

public class Mission implements IMission {

    private String codeName;
    private String state;

    public String getCodeName() {
        return codeName;
    }

    @Override
    public void CompleteMission() {
        this.state="Completed";
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getState() {
        return state;
    }

    private void setState(String state) {

        if(state.equals("inProgress") || state.equals("Finished")){
            this.state = state;
        }

    }

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    @Override
    public String toString() {
        return "Code Name: "+this.getCodeName()+" State: "+this.getState();
    }
}
