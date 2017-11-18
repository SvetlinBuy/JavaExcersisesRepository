package MilitaryElite;

import MilitaryElite.Intefaces.ISpy;

public class Spy extends Soldier implements ISpy {

    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }


    @Override
    public String toString() {
        return "Name: "+this.getFirstName()+" "+this.getLastName()+" Id: "+this.getId()+"\n" +
                "Code Number: "+this.getCodeNumber();
    }
}
