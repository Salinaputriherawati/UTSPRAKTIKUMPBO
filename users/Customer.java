package users;

public class Customer {
    static int customerId = 0;
    int id;
    String name;
    String status = "customer";

    public Customer( String name ) {
        customerId++;
        this.id = customerId;
        this.name = name;
    }

    public void getInfo() {
        System.out.println("Customer ID: " + id + "\nName: " + name + "\nStatus: " + status);
    }

    public String name() {
        return name;
    }
    
}
