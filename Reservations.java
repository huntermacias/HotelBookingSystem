package org.example.OOP;

import java.util.Date;
import java.util.List;

public class Reservations {

    public static void main(String[] args) {
        // Create instances
        BookingSystem bookingSystem = new BookingSystem();
        Hotel theHilton = new Hotel("The Hilton", "New York");
        Hotel costcoInn = new Hotel("The Costco Inn", "Seattle");

        // Add rooms
        theHilton.addRoom(new Room(RoomType.SINGLE, 200));
        theHilton.addRoom(new Room(RoomType.DOUBLE, 325));
        theHilton.addRoom(new Room(RoomType.SUITE, 600));
        costcoInn.addRoom(new Room(RoomType.SINGLE, 150));
        costcoInn.addRoom(new Room(RoomType.DOUBLE, 250));

        // Add hotels to Booking system
        bookingSystem.addHotel(theHilton);
        bookingSystem.addHotel(costcoInn);

        // Create users
        User user1 = new User("Craig Jelinek", "cjelinek@costco.com");
        User user2 = new User("Paris Hilton", "philton@wealth.com");

        // Add users to booking system
        bookingSystem.addUser(user1);
        bookingSystem.addUser(user2);

        // Search for hotels in Seattle
        List<Hotel> seattleHotels = bookingSystem.searchHotels("Seattle");
        printHeader("Search Results For: Seattle");
        for (Hotel hotel : seattleHotels) {
            System.out.println(" - " + hotel.getName());
        }

        // Make reservations
        boolean reservation1 = bookingSystem.makeReservation(
                user1,
                costcoInn,
                RoomType.SINGLE,
                new Date(),
                new Date(System.currentTimeMillis() + 86400000)
        );

        boolean reservation2 = bookingSystem.makeReservation(
                user2,
                theHilton,
                RoomType.SUITE,
                new Date(),
                new Date(System.currentTimeMillis() + 172800000)
        );

        // Reservation status
        printHeader("Reservation Status");
        System.out.println(" - Reservation 1 (Craig Jelinek): " + (reservation1 ? "✅ Successful" : "❌ Failed"));
        System.out.println(" - Reservation 2 (Paris Hilton): " + (reservation2 ? "✅ Successful" : "❌ Failed"));

        // Display user bookings
        printHeader("Craig Jelinek's Bookings");
        for (Booking booking : user1.getBookings()) {
            System.out.println(" - Hotel: " + booking.getHotel().getName() + ", Room: " + booking.getRoom().getType());
        }

        printHeader("Paris Hilton's Bookings");
        for (Booking booking : user2.getBookings()) {
            System.out.println(" - Hotel: " + booking.getHotel().getName() + ", Room: " + booking.getRoom().getType());
        }

        printFooter("End of Reservations");
    }

    private static void printHeader(String header) {
        System.out.println("\n====================================");
        System.out.printf("         %s         \n", header);
        System.out.println("====================================");
    }

    private static void printFooter(String footer) {
        System.out.println("\n====================================");
        System.out.printf("         %s         \n", footer);
        System.out.println("====================================\n");
    }
}
