# Hotel Booking System - Practice Assignment

## Overview

This project is a practice assignment to prepare for a Quality Engineering interview. It involves designing and implementing a hotel booking system using object-oriented programming principles. The system allows users to search for hotels, make reservations, and manage their bookings.

## Features

- **Hotel Management:** Add and manage hotels with various room types.
- **User Management:** Create and manage users.
- **Booking System:** Make and cancel reservations.
- **Search Functionality:** Search for hotels based on location.
- **Room Availability Check:** Ensure rooms are available for the desired dates.

## Classes and Structure

### `Hotel`

- **Attributes:** `name`, `location`, `rooms`
- **Methods:** `addRoom()`, `getName()`, `getLocation()`, `isRoomAvailable()`

### `Room`

- **Attributes:** `type`, `price`, `bookings`
- **Methods:** `getType()`, `getPrice()`, `isAvailable()`, `addBooking()`

### `User`

- **Attributes:** `name`, `email`, `bookings`
- **Methods:** `getName()`, `getEmail()`, `addBooking()`, `getBookings()`

### `Booking`

- **Attributes:** `user`, `hotel`, `room`, `checkIn`, `checkOut`
- **Methods:** `conflictsWith()`

### `BookingSystem`

- **Attributes:** `hotels`, `users`
- **Methods:** `addHotel()`, `addUser()`, `searchHotels()`, `makeReservation()`, `cancelReservation()`

```java
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
```

### Output Example

```bash
====================================
         Search Results For: Seattle         
====================================
 - The Costco Inn

====================================
          Reservation Status         
====================================
 - Reservation 1 (Craig Jelinek): ✅ Successful
 - Reservation 2 (Paris Hilton): ✅ Successful

====================================
         Craig Jelinek's Bookings         
====================================
 - Hotel: The Costco Inn, Room: SINGLE

====================================
         Paris Hilton's Bookings         
====================================
 - Hotel: The Hilton, Room: SUITE

====================================
         End of Reservations         
====================================
```
