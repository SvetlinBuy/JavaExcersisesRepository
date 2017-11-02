package DC;

public class BankAccount {

    private  int id;
    private  Double balance;

    public BankAccount(int id) {
        this.id = id;
        this.balance = 0.0;
    }

     void deposit(Double amount) {


        if(amount >= 0.0){
            this.balance += amount;
        }

    }

     void withdraw(Double amount) {
        if (this.balance - amount >=  0.0) {
            this.balance -= amount;
        }else {
            System.out.println("Insufficient balance");
        }
    }

    public Double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.getBalance());
    }
}
