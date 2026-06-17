package james_app;

import java.util.Comparator;
import entities.Account;

public class AccountByBalanceComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2){
        // vergleicht kontostände:
        return Double.compare(o1.getBalance(), o2.getBalance());
    }
}
