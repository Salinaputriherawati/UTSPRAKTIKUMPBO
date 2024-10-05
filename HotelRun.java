import users.*;
import java.util.Scanner;
public class HotelRun {
    public static void main(String[] args) throws Exception {
        String roomName;
        boolean isLoop = true;
        boolean isRunning = true;

        Scanner input = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (isRunning) {
            String status;
            
            System.out.println("\n\nWelcome to the hotel");
            System.out.println("Enter your status: ");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            int selector = input.nextInt();
            input.nextLine();

            if(selector == 1) {
                String password = "admin";
                System.out.print("Enter password: ");
                String pass = input.nextLine();
                if(!pass.equals(password)) {
                    System.out.println("Invalid password");
                    continue;
                } else{
                    status = "admin";
                }
            } else if(selector == 2) {
                status = "customer";
            } else {
                System.out.println("Invalid choice");
                continue;
            }


    
            isLoop = true;
            if(status.equals("admin")) {
                Admin admin = new Admin("Admin");
                System.out.println("\nWelcome Admin\n");
                
                while (isLoop) {
                    admin.getInfo();
                    System.out.println();
                    hotel.showMenu("admin");
        
                    System.out.print("Enter your choice: ");
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.println();
    
    
                    switch (choice) {
                        case 1:
                            hotel.showRoom("admin");
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
        
                        case 2:
                            System.out.println("Enter room name: ");
                            roomName = input.nextLine();
                            hotel.checkAvailability(roomName);
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
        
                        case 3:
                            System.out.print("Enter room name: ");
                            roomName = input.nextLine();
                            System.out.println();
                            hotel.orderDetails(roomName);
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
                        
                        case 4:
                            isLoop = false;
                            break;

                        case 0:
                            isRunning = false;
                            isLoop = false;
                            break;
    
                        default:
                            System.out.println("Invalid choice");
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
                    }
                }
                
    
            } else {
                System.out.println("Welcome Customer");
                System.out.print("Enter your name: ");
                String name = input.nextLine();
                Customer customer = new Customer(name);
    
                System.out.println("\nWelcome " + customer.name() + "\n");
                
                while (isLoop) {
                    customer.getInfo();
                    System.out.println();
                    hotel.showMenu("customer");
        
                    System.out.print("Enter your choice: ");
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.println();
    
    
                    switch (choice) {
                        case 1:
                            hotel.showRoom("admin");
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
    
                        case 2:
                            System.out.print("Enter room name: ");
                            roomName = input.nextLine();
                            hotel.orderRoom(roomName, customer.name());
                            System.out.println();
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
        
                        case 3:
                            System.out.print("Enter room name: ");
                            roomName = input.nextLine();
                            hotel.checkAvailability(roomName);
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
        
                        case 4:
                            System.out.print("Enter room name: ");
                            roomName = input.nextLine();
                            System.out.println();
                            hotel.orderDetails(roomName);
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
                        case 5:
                            System.out.print("Enter room name: ");
                            roomName = input.nextLine();
                            hotel.checkOut(roomName, customer.name());
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
                        
                        case 6:
                            isLoop = false;
                            break;

                        case 0:
                            isRunning = false;
                            isLoop = false;
                            break;
    
                        default:
                            System.out.println("Invalid choice");
                            System.out.println("\nPress enter to continue...");
                            input.nextLine();
                            break;
                    }
                }
                
            }
        }
        input.close();
        System.out.println("Thank you for visiting our hotel.");
    }
}
