package entities;

public class Customer extends Person {
    private int customerid;
    private String email;
    private String phone;

    public Customer( int id, String name,String email) {
        super(name);

        this.customerid  = id;
        this.setEmail(email);
    }

    public String getPhone() {
        return phone;
    }

    public Customer(int id, String name, String email, String phone){
        super(name);
        this.customerid = id;
        this.email = email;
        this.phone = phone;
    }
    public Customer(Customer other){
        super(other.getName());
        this.customerid  = other.customerid;
        this.email = other.email;
        this.phone = other.phone;
    }

    public void setEmail(String email) {
        if(email != null && email.contains("@") && email.contains(".") )
            this.email = email;
        else {
            throw new IllegalArgumentException("Invalide Email. muss '@' und '.' beinhalten");
        }
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return customerid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", name='" + getName() + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public String customerDetails(){
        return "*** Customer\n" +
                "customerID: " + customerid + "\n" +
                "name: " + getName() + "\n" +
                "email: " + email + "\n" +
                "phone: " + phone + "\n" +
                "***";
    }
}

