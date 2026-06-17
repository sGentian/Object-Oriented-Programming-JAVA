package entities;


public abstract class Account implements Comparable<Account> {
    private final int accountId;
    protected double balance;
    private Customer owner;


    protected Account(Account account) {
        this.accountId = account.accountId;
        this.balance = account.balance;
        this.owner = new Customer(account.owner);

    }

    @Override
    public int compareTo(Account o) {
        return Double.compare(this.balance, o.balance);
    }

    protected Account(Customer customer, int id) {
        this.owner = new Customer(customer);
        this.accountId = id;

    }

    public void setOwner(Customer owner) {
        if (owner != null)
            this.owner = owner;
        else {
            throw new IllegalArgumentException("Owner kann nicht null sein");
        }
    }


    //ede Unterklasse muss withdraw implementieren
    public abstract boolean withdraw(double amount);

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public int getId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", ownerId=" + owner.getID() +
                ", balance=" + balance +
                '}';
    }

    public String accountDetails() {
        return "*** Account\n" +
                "account ID=" + accountId +
                ", owner ID=" + owner.getID() +
                ", balance=" + balance + "\n" +
                "***";
    }
}
