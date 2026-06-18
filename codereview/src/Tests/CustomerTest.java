package Tests;


import entities.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {
    @Test
    public void TestEmail (){
        Customer customer = new Customer(1, "bwdi", "eivven@gmail.com");

        org.testng.Assert.assertEquals(customer.getEmail(), "eivven@gmail.com");
    }
}
