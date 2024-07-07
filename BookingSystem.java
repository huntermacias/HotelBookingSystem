package org.example.OOP;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingSystem {
    private List<Hotel> hotels;
    private List<User> users;

    public BookingSystem() {
        this.hotels = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Hotel> searchHotels(String location) {
        List<Hotel> results = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if(hotel.getLocation().equals(location)) {
                results.add(hotel);
            }
        }
        return results;
    }

    public boolean makeReservation(User user, Hotel hotel, RoomType roomType, Date checkIn, Date checkOut) {
        for(Room room : hotel.getRooms()) {
            if(room.getType() == roomType && room.isAvailable(checkIn, checkOut)) {
                Booking booking = new Booking(user, hotel, room, checkIn, checkOut);
                room.addBooking(booking);
                user.addBooking(booking);
                return true;
            }
        }
        return false;
    }

    public void cancelReservation(User user, Booking booking) {
        booking.getRoom().getBookings().remove(booking);
        user.getBookings().remove(booking);
    }
}
