package entities;

import java.util.ArrayList;
import java.util.List;

public class JoinedAccount extends Account{
    List<Customer> AccList = new ArrayList<>();

    protected JoinedAccount(Account account) {
        super(account);
    }

    public JoinedAccount(Customer customer, int id) {
        super(customer, id);
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    public void addCustomers (Customer c) throws Exception {
        if (AccList.contains(c))
            throw new Exception("ist schon drinnen");
        else
            AccList.add(c);
    }
}
