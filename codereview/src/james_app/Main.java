package james_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import entities.*;

public class Main {
    public static void main(String[] args) {


        Customer customer1 = new Customer(1, "Max", "max@email.com", "12345678");
        Customer customer2 = new Customer(2, "Anna", "anna@email.com", "33333333");
        Customer customer3 = new Customer(3, "Paul", "paul@email.com", "22222222");
        Customer customer4 = new Customer(4, "Lisa", "lisa@email.com", "11111111");
        Customer customer5 = new Customer(5, "Tom", "tom@email.com", "55555555");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.sort(new ComparatorNumber());
        System.out.println("sort by phone:");
        for (Customer c : customers){
            System.out.println("Customer: "+c);
        }

        customers.sort(new ComparatorName());
        System.out.println("sort by Name:");
        for (Customer c : customers){
            System.out.println("Customer: "+c);
        }


        SavingsAccount sa1 = new SavingsAccount(customer1,1,2000.0);
        SavingsAccount sa2 = new SavingsAccount(customer2,2,1000.0);
        SavingsAccount sa3 = new SavingsAccount(customer3,3,1500.0);

        List <SavingsAccount> savingslist = new ArrayList<>();

        savingslist.add(sa1);
        savingslist.add(sa2);
        savingslist.add(sa3);

        for (SavingsAccount sa : savingslist) {
            System.out.println("savings for Account: " + sa);
        }






    }
}


