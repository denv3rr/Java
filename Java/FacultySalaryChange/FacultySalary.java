//********************************************************************
//
//  Author:        Denver Clark
//
//  Program #:     Seven
//
//  File Name:     Program7.java
//
//  Course:        ITSE 2321 Object-Oriented Programming
//
//  Due Date:      7/9/2022
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       Chapters 2-6 & 15 
//
//  Description:   The trustees of a small college are considering voting a pay raise for their faculty
//  members. They want to grant a 4 percent raise for those earning more than $70,000.00,
//  a 7 percent raise for those earning more than $50,000.00 and 5.5 percent raise for all
//  others. However, before doing so, they want to know how much this will cost.
//
//  Write a program that will print:
//  the faculty number, the old salary, the raise percentage, the pay raise, and the new salary
//  for each faculty member in a five-column format with headings. Also print the total
//  amount of the raises, the average of the raises, and the total and average of the faculty
//  payroll before and after the raise. Use the end of file as a sentinel value. The input data
//  is available in Program7.txt. 
//
//********************************************************************

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program7 {

    private Scanner input;
    private ArrayList<Double> payroll = new ArrayList<>();

    // ***************************************************************
    //
    // Method: main
    //
    // Description: The main method of the program
    //
    // Parameters: A String Array
    //
    // Returns: N/A
    //
    // **************************************************************
    public static void main(String[] args) {
        Program7 myObject = new Program7();

        developerInfo();

        // Start:
        myObject.openFile();
        myObject.readRecords();
        myObject.calculateRaise();
    }

    // ***************************************************************
    //
    // Method: openFile
    //
    // Description: Opens text file in input.
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public void openFile() {
        try {
            input = new Scanner(new File("Program7.txt"));
        } catch (IOException e) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    // ***************************************************************
    //
    // Method: readRecords
    //
    // Description: Reads file that was input through openFile() method
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************

    public void readRecords() {
        try {
            while (input.hasNext()) // while there is more to read
            {
                // display record contents
                payroll.add(input.nextDouble());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
            System.exit(1); // terminate the program
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    // ***************************************************************
    //
    // Method: calculateRaise
    //
    // Description: This method calculates data and organizes it into readable
    // columns.
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************

    public void calculateRaise() {
        System.out.println("Before Payroll\t\tRaise Percent\t\tRaise Amount\t\tAfter Payroll");

        double raisePercent;
        double raiseAmount;
        double totalBeforePay = 0;
        double totalAfterPay = 0;

        for (int i = 0; i < payroll.size(); i++) {

            if (payroll.get(i) > 70000) { // Over 70k
                raisePercent = 4;
            } else if (payroll.get(i) > 50000) { // Over 50k
                raisePercent = 7;
            } else { // Other salaries
                raisePercent = 5.5;
            }
            raiseAmount = payroll.get(i) * raisePercent / 100;

            System.out.printf("%10.2f\t\t%3.1f%%\t\t\t%10.2f\t\t%10.2f%n",
                    payroll.get(i),
                    raisePercent,
                    raiseAmount,
                    payroll.get(i) + raiseAmount);

            totalBeforePay += payroll.get(i);
            totalAfterPay += payroll.get(i) + raiseAmount;
        }

        System.out.printf("Total raises ($): %10.2f%n", totalAfterPay - totalBeforePay);
        System.out.printf("Average raise (%): %10.2f%n",
                (totalAfterPay - totalBeforePay) * 100.0 / totalBeforePay);
        System.out.printf("Average raise amount  : %10.2f%n",
                (totalAfterPay - totalBeforePay) / payroll.size());
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
                "-------------------------------------------------------------------------------------------\n");
        System.out.println("Name:    Denver Clark");
        System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
        System.out.println("Program: Seven \n");
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
    } // End of developerInfo
}
