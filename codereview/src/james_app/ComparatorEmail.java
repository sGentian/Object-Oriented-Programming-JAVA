package james_app;

import entities.Customer;

import java.util.Comparator;
import java.util.Currency;

public class ComparatorEmail implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
