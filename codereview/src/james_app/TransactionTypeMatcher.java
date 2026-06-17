package james_app;

import entities.Transaction;

public class TransactionTypeMatcher implements TransactionMatcher {
    private TransactionType typeToMatch;

    public TransactionTypeMatcher(TransactionType typeToMatch) {
        this.typeToMatch = typeToMatch;
    }
    @Override
    public boolean match(Transaction transaction){
        if (this.typeToMatch == transaction.getType()) {
            return true;
        }
        return false;
    }
}
