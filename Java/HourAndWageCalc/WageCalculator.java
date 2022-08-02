//********************************************************************
//
//  Author:        Denver Clark
//
//  Program #:     12
//
//  File Name:     Program12.java
//
//  Course:        ITSE 2321 Object-Oriented Programming
//
//  Due Date:      8/1/2022
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       Ch. 2-14
//
//  Description:   This program calculates an
//                 employee's monthly pay.
//                 It takes in: name, hours worked,
//                 and pay rate and returns a
//                 formatted note with monthly
//                 calculations included.
//
//********************************************************************

import java.util.*;

public class HourlyEmployeeTest {

    // Create scanner
    Scanner input = new Scanner(System.in);

    // Create an HourlyEmployee
    HourlyEmployee employee;

    // This method takes input from the user to avoid needing to do it during the
    // main method.
    public boolean getInput() {

        String name;
        String[] splitnames;

        // Get name of employee as an input
        System.out.print("\n\nEmployee Name: ");
        name = input.nextLine();

        // Options to exit early
        if (name.equals("no") || name.equals("exit") || name.equals("n")) {
            System.out.println("\n\nProgram stopped.");
            return false;
        }

        // Account for the space between words in the employee's name
        splitnames = name.split(" ");

        // Get rate
        System.out.print("Hourly rate: $");
        double rate = input.nextDouble();

        // Clear buffer
        input.nextLine();

        // Get hours worked
        System.out.print("Hours worked: ");
        String hourLine = input.nextLine();

        // Format to allow commas within input between numbers.
        String[] hours = hourLine.split(",");
        double totalhours = 0;
        double regularHours = 0, overtimeHours = 0;

        // Any hours over 40 are accumulated in the overtimeHours variable.
        // Total hours are calculated next.
        for (String hour : hours) {
            totalhours = Double.parseDouble(hour);
            if (totalhours > 40) {
                regularHours += 40;
                overtimeHours = overtimeHours + (totalhours - 40);
            } else {
                regularHours += totalhours;
            }
        }

        // Instance of employee
        employee = new HourlyEmployee(splitnames[0], splitnames[1], rate, regularHours + overtimeHours);
        employee.setRegularHours(regularHours);
        employee.setOvertimeHours(overtimeHours);
        return true;
    }

    // ***************************************************************
    //
    // Method: developerInfo
    //
    // Description: The developer information method of the program
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public static void developerInfo() {
        System.out.println(
                "\n\n\n-------------------------------------------------------------------------------------------\n");
        System.out.println("Name:    Denver Clark");
        System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
        System.out.println("Program: 12 \n");
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
    } // End of developerInfo

    // ***************************************************************
    //
    // Method: main
    //
    // Description: The main method of the program
    //
    // Parameters: String array
    //
    // Returns: N/A
    //
    // **************************************************************
    public static void main(String[] args) {

        // Greeting + info
        System.out.println("\n\n*********************************\n\nWelcome.\n\n" +
                "To exit during the process,\ntype 'n', 'no', or 'exit' as the employee name.");

        // Declare variables here
        HourlyEmployeeTest test = new HourlyEmployeeTest();

        // Keep program running after finishing each run until user exits or an error
        // occurs.

        // I added options for the user to type "exit", "no", or "n" in order to force
        // exit the program early.
        while (test.getInput()) {
            test.employee.calculateNetPay();
            test.employee.displayDetails();
        }

        developerInfo();

    } // End of the main method
}

// Start of HourlyEmployee class
public class HourlyEmployee extends Employee {

    // Declare variables
    private double regularHours;
    private double overtimeHours;
    private double regularPay;
    private double overtimePay;
    private double grossPay;
    private double tax;
    private double netPay;

    // HourlyEmployee object that will be used to create an instance of an employee
    // for data input
    public HourlyEmployee(String firstName, String lastName, double payRate, double totalHours) {
        super(firstName, lastName, payRate);
        if (totalHours > 40) {
            this.regularHours = 40;
            this.overtimeHours = totalHours - this.regularHours;
        } else {
            this.regularHours = totalHours;
            this.overtimeHours = 0;
        }
    }

    // Set parameters for type of hours being worked
    public void setHours(double totalHours) {
        if (totalHours > 40) {
            this.regularHours = 40;
            this.overtimeHours = totalHours - this.regularHours;
        } else {
            this.regularHours = totalHours;
            this.overtimeHours = 0;
        }
    }

    public double getRegularHours() {
        return this.regularHours;
    }

    public void setRegularHours(double hrs) {
        this.regularHours = hrs;
    }

    public void setOvertimeHours(double hrs) {
        this.overtimeHours = hrs;
    }

    public double getOvertimeHours() {
        return this.overtimeHours;
    }

    public double getRegualarPay() {
        return this.regularPay;
    }

    public double getOvertimePay() {
        return this.overtimePay;
    }

    // Displays the formatted details of the current employee
    public void displayDetails() {
        System.out.println("\n\n*********************************\n\n" + super.toString());
        System.out.println(String.format("%n%s: %.2f%n%s: %.2f",
                "Total Regular Hours Worked", this.getRegularHours(),
                "Total Overtime Hours Worked", this.getOvertimeHours()));
        System.out.println(String.format("%n%s: $%.2f%n%s: $%.2f", "Monthly Regular Pay", this.getRegualarPay(),
                "Monthly overtime pay", this.getOvertimePay()));
        System.out.println(String.format("%n%s: $%.2f%n%s: $%.2f%n%s: $%.2f", "Monthly Gross Pay", this.grossPay,
                "Monthly Taxes Paid", this.tax, "Monthly Net Pay",
                this.netPay) + "\n\n*********************************\n");
    }

    // Calculate tax rates for each of the income brackets and add the amount to the
    // total as net pay based.
    public void calculateNetPay() {
        this.regularPay = this.regularHours * this.getPayRate();
        this.overtimePay = this.overtimeHours * this.getPayRate() * 1.5;
        this.grossPay = this.regularPay + this.overtimePay;
        if (this.grossPay > 0 && this.grossPay <= 2000) {
            this.tax = 0.10 * grossPay;
        } else if (grossPay > 2000 && grossPay <= 3500) {
            this.tax = 0.15 * grossPay;
        } else if (grossPay > 3500 && grossPay <= 6000) {
            this.tax = 0.28 * grossPay;
        } else if (grossPay > 6000 && grossPay <= 10000) {
            this.tax = 0.31 * grossPay;
        } else if (grossPay > 10000) {
            this.tax = 0.36 * grossPay;
        }
        this.netPay = this.grossPay - this.tax;
    }
}

// ********************************************************************
//
// Author: Instructor
//
// Program #: 12
//
// File Name: Employee.java
//
// Course: ITSE 2321 Object-Oriented Programming
//
// Due Date: 8-01-2022
//
// Instructor: Prof. Fred Kumi
//
// Chapter: Chapters 2 - 14
//
// Description: Employee class. Please do NOT modify this Class.
// If you do, you will not receive credit for Program 12.
//
// ********************************************************************

/**
 * The Class Employee.
 */
public class Employee extends Object {
    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The pay rate. */
    private double payRate;

    /**
     * Instantiates a new employee.
     */
    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.payRate = 0.0;
    }

    /**
     * Instantiates a new employee.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param payRate    the pay rate
     * @param totalHours the hours worked
     */
    public Employee(String firstName, String lastName, double payRate) {
        if (payRate < 0.0)
            throw new IllegalArgumentException("Pay rate must be > 0.0");
        else if (payRate < 7.25)
            payRate = 7.25;

        this.firstName = firstName;
        this.lastName = lastName;
        this.payRate = payRate;
    } // end constructor

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name
     * @return the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the pay rate.
     *
     * @param payRate the new pay rate
     */
    public void setPayRate(double payRate) {
        if (payRate < 0.0)
            throw new IllegalArgumentException("Pay rate must be >= 0.0");
        else if (payRate < 7.25)
            this.payRate = 7.25;
        else
            this.payRate = payRate;
    }

    /**
     * Gets the pay rate.
     *
     * @return the pay rate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * 
     * Returns the String representation of an Employee object.
     *
     * @return the string
     */
    @Override // indicates that this method overrides a superclass method
    public String toString() {
        return String.format("%s: %s %s%n%s: %.2f",
                "Employee", firstName, lastName,
                "Pay rate", payRate);
    }
} // End class Employee
