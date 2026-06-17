package entities;

public class KidsAccount extends SavingsAccount {
    private Customer parent;

    public KidsAccount(Customer customer, int id, Customer parent) {
        super(customer, id);
        this.parent = customer;
    }

    @Override
    public String toString() {
        return "KidsAccount{" +
                "parent=" + parent +
                super.toString() +
                '}';
    }

    public boolean withdraw (double amount){
        System.out.println("Warning Kids-Account");

        return super.withdraw(amount);
    }
}

