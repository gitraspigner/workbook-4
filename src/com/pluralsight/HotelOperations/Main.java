package com.pluralsight.HotelOperations;

/**
 * Simulates few of the operations of a hotel including create a reservation for a room,
 * check out of a room, clean a room, and allow an employee to punch in or out of their shift.
 *
 * @author Ravi Spigner
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----Hotel Operations Test Program----");
        //initialize hotel data
        Hotel hotel = new Hotel("The Grand Budapest", 5, 5);
        Employee frontDeskEmployee = new Employee(7654111, "Jim Thompson", "Front Desk",
                20.00, 42.50);
        Room room327 = new Room("King");
        Reservation reservation1 = new Reservation("King",5,
                true);
        //print hotel data
        System.out.println("----Employee Data, Punch-In Time (8AM/8:00)----");
        frontDeskEmployee.punchIn(8.00);
        System.out.println(frontDeskEmployee);
        System.out.println("----Pre Check In & Booking----");
        System.out.println(hotel);
        System.out.println(room327);
        System.out.println(reservation1);
        room327.checkIn();
        hotel.bookRoom(1, true);
        System.out.println("----Post Check In & Booking----");
        System.out.println(hotel);
        System.out.println(room327);
        room327.checkOut();
        System.out.println("----Post Check Out (not including Unbooking)----");
        System.out.println(room327);
        room327.cleanRoom();
        hotel.unbookRoom(1, true);
        System.out.println("----Post Room Clean & Unbooking----");
        System.out.println(hotel);
        System.out.println(room327);
        System.out.println("----Employee Data, Punch-Out Time (5PM/17:00)----");
        frontDeskEmployee.punchOut(17.00);
        System.out.println(frontDeskEmployee);
        System.out.println("----Employee Data, No Args Punch In / Punch Out----");
        frontDeskEmployee.punchIn();
        frontDeskEmployee.punchOut();
        System.out.println("----Finished execution without error.----");
    }
}
