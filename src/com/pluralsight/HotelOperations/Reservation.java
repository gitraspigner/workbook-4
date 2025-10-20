package com.pluralsight.HotelOperations;

/**
 * *******Add program description here******
 *
 * @author Ravi Spigner
 */
public class Reservation {
    private String roomType;
    private double price;
    private double priceMultiplier;
    private int numberOfNights;
    private boolean isWeekendReservation;

    public Reservation() {
        this.roomType = "";
        this.price = 0.0;
        this.priceMultiplier = 1.0;
        this.numberOfNights = 0;
        this.isWeekendReservation = false;
    }

    public Reservation(String roomType, int numberOfNights,
                       boolean isWeekendReservation) {
        this.roomType = roomType;
        if (roomType.equalsIgnoreCase("King")) {
            this.price = 139.00;
        } else { //any other roomtype will be intialized to a Double roomtype
            this.price = 124.00;
        }
        this.isWeekendReservation = isWeekendReservation;
        this.numberOfNights = numberOfNights;
        if (isWeekendReservation) {
            setPriceMultiplier(1.10);
        } else {
            setPriceMultiplier(1.00);
        }
    }

    public Reservation(String roomType, double price, int numberOfNights,
                       boolean isWeekendReservation) {
        this.roomType = roomType;
        this.price = price;
        this.isWeekendReservation = isWeekendReservation;
        this.numberOfNights = numberOfNights;
        if (isWeekendReservation) {
            setPriceMultiplier(1.10);
        } else {
            setPriceMultiplier(1.00);
        }
    }

    @Override
    public String toString() {
        return  "Reservation ** Room Type: " + roomType +
                " | Weekend Reservation: " + isWeekendReservation +
                " | Nightly Price: " + getNightlyPrice() +
                " | Total Price: " + getTotalPrice();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getNightlyPrice() {
        return price*priceMultiplier;
    }

    public double getTotalPrice() {
        return (price*priceMultiplier) * numberOfNights;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekendReservation() {
        return isWeekendReservation;
    }

    public void setWeekendReservation(boolean weekendReservation) {
        isWeekendReservation = weekendReservation;
    }
}
