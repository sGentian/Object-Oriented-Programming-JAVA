package james_app;

import java.util.Comparator;
import entities.Customer;

public class ComparatorNumber implements Comparator<Customer> {
    @Override
    public int compare (Customer o1, Customer o2){

        return o2.getPhone().compareTo(o1.getPhone());
    }
}
