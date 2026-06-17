package entities;

import james_app.IllegalOverdraftLimitException;

public class CheckingAccount extends Account{
    private double overdraftLimit = -100;

    public CheckingAccount(Customer customer, int id) {

        super(customer, id);
    }
    public CheckingAccount(Customer customer, int id, double initialAmount) {
        //ruft den oberen konstruktor auf
        this(customer, id);
        this.balance = initialAmount;
    }
    @Override
    public boolean withdraw(double amount) {

        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            return true;
        }

        return false;
    }
    public void setOverDraftLimit(int limit) throws IllegalOverdraftLimitException {

        if (limit > 0) {
            throw new IllegalOverdraftLimitException(
                    "Overdraft limit must be 0 or negative."
            );
        }

        this.overdraftLimit = limit;
    }


    public String toString() {
        //greift auf tostring von superclass zu
        return super.toString() +
                ", overdraftLimit=" + overdraftLimit;
    }
}





