package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import james_app.*;
import entities.*;

public class CheckingSavingsAccountTest {
    @Test
    public void TestWithdrawPos() {
        Customer customer = new Customer(1, "Anton", "anton@gmail.com");
        CheckingAccount c = new CheckingAccount(customer, 2 , 2000);

        boolean test1 = c.withdraw(1000);
        Assert.assertTrue(test1);
        Assert.assertEquals(c.getBalance(), 1000.0);
    }
    @Test
    public void TestWithdrawLimit(){
        Customer customer = new Customer(1, "Mista", "mista@gmail.com");
        CheckingAccount c = new CheckingAccount(customer, 2, 1500 );

        boolean test = c.withdraw(1600);
        Assert.assertTrue(test);
        Assert.assertEquals(c.getBalance(), -100.0);
    }
    @Test
    public void TestWithdrawException (){
        Customer customer = new Customer(1, "Giorno", "giorno@gmail.com");
        CheckingAccount c = new CheckingAccount(customer, 2, 2000 );
        boolean test = c.withdraw(4000);
        Assert.assertFalse(test);
        //ob balance unverändert weil test false gibt
        Assert.assertEquals(c.getBalance(), 2000.0);
    }

    @Test (expectedExceptions = IllegalOverdraftLimitException.class)
    public void testexception() throws IllegalOverdraftLimitException {
        Customer customer = new Customer(1, "max", "max@gmail.com");
        CheckingAccount c = new CheckingAccount(customer, 2, 2000 );
        c.setOverDraftLimit(200);
        boolean funktion = c.withdraw(500);
        Assert.assertTrue(funktion);
        Assert.assertEquals(c.getBalance(), 1500.0);

    }

}
