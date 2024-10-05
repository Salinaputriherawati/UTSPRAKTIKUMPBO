package users;

public class Admin extends Customer {
    static int AdminId = 0;
    int id;
    String status = "admin";

    public Admin(String name) {
        super(name);
        AdminId++;
        this.id = AdminId;
    }
    
    @Override
    public void getInfo() {
        System.out.println("Admin ID: " + id + "\nName: " + name + "\nStatus: " + status);
    }
    
    
}
