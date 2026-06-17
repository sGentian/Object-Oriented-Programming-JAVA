package james_app;

import java.util.Comparator;
import entities.Account;

public class AccountByIDComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        if (o1.getId() < o2.getId()) {
            return -1;
        } else if (o1.getId() == o2.getId()) {
            return 0;
        } else {
            return 1;
        }
    }
}