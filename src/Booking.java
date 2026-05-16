class Booking {
    String customerName;
    int bookingId;
    Room room;
    Booking(String customerName, int bookingId, Room room) {
        this.customerName = customerName;
        this.bookingId = bookingId;
        this.room = room;
    }
    void displayBooking() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Booking ID    : " + bookingId);
        System.out.println("Room Number   : " + room.roomNumber);
        System.out.println("Room Type     : " + room.roomType);
        System.out.println();
    }
}
