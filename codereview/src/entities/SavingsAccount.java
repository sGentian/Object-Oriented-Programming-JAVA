package entities;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer, int id){
        super(customer, id);
    }
    public SavingsAccount(Customer customer, int id, double initialAmount){
        this( customer, id);
        this.balance = initialAmount;

    }
    public SavingsAccount(Account account){
        super(account); // nutzt copy konstruktor von Account
    }
    public boolean withdraw(double amount){
        if (amount > 0 && balance >= -amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

}
