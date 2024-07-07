package org.example.OOP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum RoomType { SINGLE, DOUBLE, SUITE };

public class Room {

    private RoomType type;
    private double price;
    private List<Booking> bookings;

    public Room(RoomType type, double price) {
        this.type = type;
        this.price = price;
        this.bookings = new ArrayList<>();
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean isAvailable(Date checkIn, Date checkOut) {
        for (Booking booking : bookings) {
            if(booking.conflictsWith(checkIn, checkOut)){
                return false;
            }
        }
        return true;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }


}
