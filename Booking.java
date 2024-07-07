package org.example.OOP;

import java.util.Date;

public class Booking {
    private User user;
    private Hotel hotel;
    private Room room;
    private Date checkIn;
    private Date checkOut;

    public Booking(User user, Hotel hotel, Room room, Date checkIn, Date checkOut) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public boolean conflictsWith(Date checkIn, Date checkOut) {
        return (this.checkIn.before(checkOut) && this.checkOut.after(checkIn));
    }
}
