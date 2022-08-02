
//********************************************************************
//
//  Author:        Denver Clark
//
//  Program #:     6
//
//  File Name:     Program6.java
//
//  Course:        ITSE 2321 Object-Oriented Programming
//
//  Due Date:      7/5/2022
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       6, 7
//
//  Description:   This program calculates and displays the average
//                 of six test scores, all integers, after the lowest
//                 score has been dropped.
//
//                 Please do NOT modify the main method. If you modify
//                 it, you will not receive credit for this program.
//
//********************************************************************
import java.util.Scanner;

public class Program6 {
    Scanner input = new Scanner(System.in);

    // ***************************************************************
    //
    // Method: main
    //
    // Description: The main method of the program.
    // Do NOT modify this method. If you modify it, you
    // will not receive credit for this program.
    //
    // Parameters: A String Array
    //
    // Returns: N/A
    //
    // **************************************************************
    public static void main(String[] args) {
        Program6 object = new Program6();

        int test1 = 0;
        int test2 = 0;
        int test3 = 0;
        int test4 = 0;
        int test5 = 0;
        int test6 = 0;
        int lowest = 0;
        double average = 0.0;

        developerInfo();
        displayMessage();

        // Call getScore once for each of the six test scores
        test1 = object.getScore("Please enter the 1st test scores: ");
        test2 = object.getScore("Please enter the 2nd test scores: ");
        test3 = object.getScore("Please enter the 3rd test scores: ");
        test4 = object.getScore("Please enter the 4th test scores: ");
        test5 = object.getScore("Please enter the 5th test scores: ");
        test6 = object.getScore("Please enter the 6th test scores: ");

        // Call findLowest to find and return the lowest
        lowest = object.findLowest(test1, test2, test3, test4, test5, test6);

        // Call calcAverage to calculate and return the average
        average = object.calculateAverage(test1, test2, test3, test4, test5, test6, lowest);

        // Print the average to two decimal places
        object.printAverage(average, lowest);

    } // End of the main method

    public static int getScore(String message) {
        // Ask for the score for each test within parameters set (0-100)
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        int score = input.nextInt();
        while (score < 0 || score > 100) {
            System.out.print("Invalid score. Please enter a score between 0 and 100: ");
            score = input.nextInt();
            input.close();
        }
        return score;
    }

    // ***************************************************************
    //
    // Method: calculateAverage
    //
    // Description: This method displays a message to screen
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************

    public static double calculateAverage(int test1, int test2, int test3, int test4, int test5, int test6,
            int lowest) {
        // Finds the average of all scores input
        double average = 0.0; // Initialize the average to 0
        average = (test1 + test2 + test3 + test4 + test5 + test6 - lowest) / 5.0; // Calculate the average
        return average;
    }

    public static int findLowest(int test1, int test2, int test3, int test4, int test5, int test6) {
        // Finds the lowest score out of the array and drops it from the list.
        int lowest = Math.min(test1, Math.min(test2, Math.min(test3, Math.min(test4, Math.min(test5, test6)))));
        return lowest;
    }

    public static void printAverage(double average, int lowest) {
        // Displays data output from the previous methods
        System.out.println("The lowest test score dropped was " + lowest + ".");
        // display the average to two decimal places
        System.out.println("The average of the test scores is " + String.format("%.2f", average) + ".");
    }

    // ***************************************************************
    //
    // Method: displayMessage
    //
    // Description: This method displays a message to screen
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public static void displayMessage() {
        System.out.print("This program calculates and displays ");
        System.out.println("the average of six test");
        System.out.print("scores, all integers, after the lowest ");
        System.out.println("score has been dropped. \n");
    }

    // ***************************************************************
    //
    // Method: developerInfo
    //
    // Description: The developer information method of the program
    //
    // ***************************************************************
    public static void developerInfo() {
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
        System.out.println("Name:    Denver Clark");
        System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
        System.out.println("Program: Six \n");
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
    }

} // End of Program6