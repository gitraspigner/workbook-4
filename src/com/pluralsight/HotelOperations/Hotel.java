package com.pluralsight.HotelOperations;

/**
 * Represents a count of available and occupied rooms in a Hotel. Tracks the number of rooms
 * (basic, Double bed rooms) and suites (King Size bed rooms) in a hotel, both the total number
 * of each and how many of each are currently booked. The number of currently available suites
 * and (basic/double) rooms can be retrieved. Rooms of either type can be booked.
 * A Hotel will also have a name.
 *
 * @author Ravi Spigner
 */
public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites
            , int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    @Override
    public String toString() {
        return  "Hotel ** Hotel Name: " + name +
                " | Available Suites: " + getAvailableSuites() +
                " | Available Rooms: " + getAvailableRooms() +
                " | Booked Suites: " + bookedSuites +
                " | Booked Rooms: " + bookedBasicRooms;
    }

    public int getAvailableSuites() {
        return this.numberOfSuites-this.bookedSuites;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms-this.bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= getAvailableSuites()) {
                this.bookedSuites += numberOfRooms;
                return true;
            } else {
                return false;
            }
        } else {
            if (numberOfRooms <= getAvailableRooms()) {
                this.bookedBasicRooms += numberOfRooms;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean unbookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= this.bookedSuites) {
                this.bookedSuites -= numberOfRooms;
                return true;
            } else {
                return false;
            }
        } else {
            if (numberOfRooms <= this.bookedBasicRooms) {
                this.bookedBasicRooms -= numberOfRooms;
                return true;
            } else {
                return false;
            }
        }

    }
}
