package com.pluralsight.HotelOperations;

import java.time.LocalTime;

/**
 * An employee has an ID number, a name, a department they work within (of the hotel)
 * their pay rate, the number of hours they've worked for the week, and their punch in
 * time for the current day. Regular and overtime hours worked can be retrieved. An
 * employee can punch in or out of their current shift for the current day, and their
 * time worked for the day is reflected in their time worked for the week (and overtime
 * if applicable).
 *
 * @author Ravi Spigner
 */
public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;

    public Employee() {
        this.employeeID = 0;
        this.name = "";
        this.department = "";
        this.payRate = 0.0;
        this.hoursWorked = 0.0;
        this.punchInTime = -1.0;
    }

    public Employee(int employeeID, String name, String department, double payRate,
                    double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.punchInTime = -1.0;
    }

    public double getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(double punchInTime) {
        this.punchInTime = punchInTime;
    }

    @Override
    public String toString() {
        return  "Employee ID: " + employeeID +
                " | Name: " + name +
                " | Department: " + department +
                " | Pay Rate: " + payRate +
                " | Regular Hours: " + getRegularHours() +
                " | Overtime Hours Hours: " + getOverTimeHours() +
                " | Total Hours Worked: " + hoursWorked;
    }

    public boolean isValidTime(double time) {
        return time >= 00.00 && time < 24.00;
    }

    public void punchIn() {
        LocalTime timeNow = LocalTime.now();
        double timeAsDouble = timeNow.getHour() + (timeNow.getMinute() / 60.0);
        if (isValidTime(timeAsDouble)) {
            setPunchInTime(timeAsDouble);
            System.out.println("Punch In Successful!");
        } else {
            System.out.println("Punch In Unsuccessful.");
        }
    }

    public void punchOut() {
        LocalTime timeNow = LocalTime.now();
        double timeAsDouble = timeNow.getHour() + (timeNow.getMinute() / 60.0);
        if (isValidTime(timeAsDouble) && timeAsDouble >= getPunchInTime()) {
            setHoursWorked(getHoursWorked() + (timeAsDouble - getPunchInTime()));
            System.out.println("Punch Out Successful! Hours Worked Added.");
            setPunchInTime(-1.00);
        } else {
            System.out.println("Punch Out Unsuccessful.");
        }
    }

    public void punchIn(double time) {
        if (isValidTime(time)) {
            setPunchInTime(time);
            System.out.println("Punch In Successful!");
        } else {
            System.out.println("Punch In Unsuccessful.");
        }
    }

    public void punchOut(double time) {
        if (isValidTime(time) && time >= getPunchInTime()) {
            setHoursWorked(getHoursWorked() + (time - getPunchInTime()));
            System.out.println("Punch Out Successful! Hours Worked Added.");
            setPunchInTime(-1.00);
        } else {
            System.out.println("Punch Out Unsuccessful.");
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getOverTimeHours() {
        if (hoursWorked > 40.00) {
            return hoursWorked-40.0;
        } else {
            return 0;
        }
    }

    public double getRegularHours() {
        if (hoursWorked > 40.00) {
            return 40;
        } else {
            return getHoursWorked();
        }
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
