import java.io.*;
public class Main {
    public static void main(String a[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Room[] rooms = new Room[3];
        Booking[] bookings = new Booking[100];
        int bookingCount = 0;
        rooms[0] = new Room(101, "Standard", 2000, true);
        rooms[1] = new Room(102, "Deluxe", 3500, true);
        rooms[2] = new Room(103, "Suite", 5000, true);
        int choice;
        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1:
                    System.out.println("\n--- Room Details ---");
                    for(int i = 0; i < rooms.length; i++) {
                        rooms[i].displayRoom();
                    }
                    break;
                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = Integer.parseInt(br.readLine());
                    br.readLine();
                    boolean found = false;
                    for(int i = 0; i < rooms.length; i++) {
                        if(rooms[i].roomNumber == roomNumber) {
                            found = true;
                            if(rooms[i].isAvailable == true) {
                                System.out.print("Enter Customer Name: ");
                                String name = br.readLine();
                                rooms[i].isAvailable = false;
                                bookings[bookingCount] =
                                        new Booking(name, bookingCount + 1, rooms[i]);
                                bookingCount++;
                                System.out.println("Room Booked Successfully!");
                                System.out.println("Payment Successful!");
                            } 
                            else {
                                System.out.println("Room Already Booked!");
                            }
                        }
                    }
                    if(found == false) {
                        System.out.println("Room Not Found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Booking ID to Cancel: ");
                    int cancelId = Integer.parseInt(br.readLine());
                    boolean cancelFound = false;
                    for(int i = 0; i < bookingCount; i++) {
                        if(bookings[i].bookingId == cancelId) {
                            cancelFound = true;
                            bookings[i].room.isAvailable = true;
                            System.out.println("Booking Cancelled Successfully!");
                            bookings[i] = null;
                        }
                    }
                    if(cancelFound == false) {
                        System.out.println("Booking ID Not Found!");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Booking Details ---");
                    for(int i = 0; i < bookingCount; i++) {
                        if(bookings[i] != null) {
                            bookings[i].displayBooking();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } 
        while(choice != 5);
    }
}
