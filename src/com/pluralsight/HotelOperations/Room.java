package com.pluralsight.HotelOperations;

/**
 * *******Add program description here******
 *
 * @author Ravi Spigner
 */
public class Room {
    private int numberOfBeds;
    private double price;
    private boolean available;
    private boolean dirty;

    public Room() {
        this.numberOfBeds = 0;
        this.price = 0.00;
        this.available = true;
        this.dirty = false;
    }

    public Room(String roomType) {
        if (roomType.equalsIgnoreCase("King")) {
            this.numberOfBeds = 1;
            this.price = 139.00;
            this.available = true;
            this.dirty = false;
        } else { //any other roomtype will be intialized to a Double roomtype
            this.numberOfBeds = 2;
            this.price = 124.00;
            this.available = true;
            this.dirty = false;
        }
    }

    public Room(int numberOfBeds, double price, boolean available, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.available = available;
        this.dirty = dirty;
    }

    @Override
    public String toString() {
        return  "Room ** Number Of Beds: " + numberOfBeds +
                " | Base Nightly Price: " + price +
                " | Available: " + available +
                " | Dirty: " + dirty;
    }

    public void checkIn() {
        if(isAvailable() && !isDirty()) {
            setAvailable(false);
            setDirty(true);
            System.out.println("Check In Successful!");
        } else {
            System.out.println("Check In Failed: Room is occupied and dirty.");
        }
    }

    public void checkOut() {
        if (isOccupied()) {
            setAvailable(true);
            System.out.println("Check Out Successful!");
        } else {
            System.out.println("Check Out Failed: Room was not occupied.");
        }

    }

    public void cleanRoom() {
        if(isAvailable() && isDirty()) {
            setDirty(false);
            setAvailable(true);
            System.out.println("Room Cleaning Successful!");
        } else {
            System.out.println("Room Cleaning Failed: Room was not occupied or already clean.");
        }
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isOccupied() {
        return !available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
