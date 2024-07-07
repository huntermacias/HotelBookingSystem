package org.example.OOP;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    // search for hotels, view details, make reservations, manage their bookings
    private String name;
    private String location;
    private ArrayList<Room> rooms;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public void addRoom(Room room){
        rooms.add(room);
    }

    public boolean isRoomAvailable(RoomType type, Date checkIn, Date checkOut) {
        for(Room room : rooms) {
            if(room.getType() == type && room.isAvailable(checkIn, checkOut)) {
                return true;
            }
        }
        return false;
    }
}


