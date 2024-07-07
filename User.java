package org.example.OOP;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Booking> bookings;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
