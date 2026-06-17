package james_app;

import entities.Transaction;

public interface TransactionMatcher {
    boolean match(Transaction transaction);
}
