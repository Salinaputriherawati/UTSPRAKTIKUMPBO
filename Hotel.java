public class Hotel implements HotelInterface {
    private String room[] = {
        "Room 1", "Room 2", "Room 3", "Room 4", "Room 5", "Room 6", "Room 7", "Room 8", "Room 9", "Room 10"
    };

    private boolean roomAvailable[] = {
        true, true, false, true, true, true, false, true, true, true
    };

    private String customerName[] = {
        "", "", "Salina", "", "", "", "Putri", "", "", ""
    };

    private int roomPrice[] = {
        100, 200, 300, 400, 500, 600, 700, 800, 900, 1000
    };

    public void showMenu(String status) {
        if (status == "admin") {
            System.out.println("Menu:");
            System.out.println("1. Show rooms");
            System.out.println("2. Check availability");
            System.out.println("3. Order details");
            System.out.println("4. Back");
            System.out.println("0. Exit");
        } else {

                System.out.println("Menu:");
                System.out.println("1. Show rooms");
                System.out.println("2. Order room");
                System.out.println("3. Check availability");
                System.out.println("4. Order details");
                System.out.println("5. Check out");
                System.out.println("6. Back");
                System.out.println("0. Exit");
            
        }
        
    }


    public void showRoom(String status) {
        System.out.println("List of rooms:");
        if (status.equals("admin")) {
            System.out.println("Room         Status        Price");
            System.out.println("---------------------------------");
            for (int i = 0; i < room.length; i++) {
                String setStatus = roomAvailable[i] ? "Available" : "Not Available";
                System.out.format("%-7s - %-15s - %-7s\n", room[i], setStatus, roomPrice[i]);
            }
        } else {
            System.out.println("Room        Price");
            System.out.println("---------------------------------");
            for (int i = 0; i < room.length; i++) {
                if (roomAvailable[i]) {
                    System.out.format("%-7s - %-7s\n", room[i], roomPrice[i]);
                }
            }
        }
    }

    public void orderRoom(String roomName, String customerName) {
        System.out.println("\nDetails: ");
        System.out.println("Room: " + roomName);
        System.out.println("Customer: " + customerName);
        for (int i = 0; i < room.length; i++) {
            if (room[i].toLowerCase().equals(roomName.toLowerCase())) {
                System.out.println("Price: " + roomPrice[i]);
                if (roomAvailable[i]) {
                    roomAvailable[i] = false;
                    this.customerName[i] = customerName;
                    System.out.println(roomPrice[i]);
                    System.out.println("Room is booked successfully.");
                } else {
                    System.out.println("Room is not available.");
                }
            }
        }
    }
    
    public void checkAvailability(String roomName) {
        for (int i = 0; i < room.length; i++) {
            if (room[i].toLowerCase().equals(roomName.toLowerCase())) {
                if (roomAvailable[i]) {
                    System.out.println(roomName + " is available.");
                } else {
                    System.out.println(roomName + " is not available.");
                }
            }
        }
    }
    
    public void orderDetails(String roomName) {
        System.out.println("Order details:");
        for (int i = 0; i < room.length; i++) {
            if (room[i].toLowerCase().equals(roomName.toLowerCase())) {
                System.out.println("Room: " + room[i]);
                System.out.println("Customer: " + customerName[i]);
                System.out.println("Price: " + "Rp." + roomPrice[i]);

                if(roomAvailable[i]) {
                    System.out.println("Room is available to order.");
                } 
            }
        }

    }

    public void checkOut (String roomName, String customerName) {
        for (int i = 0; i < room.length; i++) {
            if (room[i].toLowerCase().equals(roomName.toLowerCase())) {
                if(this.customerName[i].toLowerCase().equals(customerName.toLowerCase())) {
                    roomAvailable[i] = true;
                    this.customerName[i] = "";
                    System.out.println("Room is checked out successfully.");
                } else {
                    System.out.println("You didn't reserved this room.");
                }
            }
        }
    }
    

}
