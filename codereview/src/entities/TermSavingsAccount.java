package entities;

import java.time.LocalDate;
import james_app.*;

public class TermSavingsAccount extends SavingsAccount {
    LocalDate end;

    public TermSavingsAccount(Customer customer, int id, double initialAmount, TermDuration duration) {
        super(customer, id, initialAmount);
        this.balance = initialAmount;
        this.end = TermDuration.getDateAfterDuration(duration); // end = heute + duration
    }

    public   TermSavingsAccount(Account account, TermDuration duration) {
        super(account);// ruft deep copy in account
        if(duration == null){
            throw new IllegalArgumentException("duration");
        }
        this.end = TermDuration.getDateAfterDuration(duration); // end = heute + duration
    }

    public boolean withdraw(double amount) {
        if (LocalDate.now().isAfter(end)) { //nur wenn dannach versucht
            return super.withdraw(amount); // erlaubt
        } else {
            throw new TermNotReachedException("Withdrawal not allowed until: " + end);

        }

    }
}
