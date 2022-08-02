//********************************************************************
//
//  Author:        Denver Clark
//
//  Program #:     Eight
//
//  File Name:     Program8.java
//
//  Course:        ITSE 2321 Object-Oriented Programming
//
//  Due Date:      7/19/2022
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       8-9
//
//  Description:   This program is a test program that creates random simple math problems
//                 and returns a response based on the correctness of the answer.
//
//********************************************************************

import java.util.*;

public class Program8 {

    // Create Arrays for the responses to the test questions.
    String positive_responses[] = { "Excellent!", "Very good!", "Nice work!", "Way to go!", "Keep up the good work!" };
    String negative_responses[] = { "That is incorrect!", "No. Please try again!", "Wrong, Try once more!",
            "No. Don't give up!", "Incorrect. Keep trying!" };

    // Create random instance
    Random num = new Random();

    Scanner ans = new Scanner(System.in);
    int numlimit = 10;

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
    // ***************************************************************
    public static void main(String[] args) {
        // Create Program8 object
        Program8 myObject = new Program8();

        // Start:
        myObject.questions();
        myObject.test();

        // Developer Info:
        developerInfo();
    }

    // ***************************************************************
    //
    // Method: questions
    //
    // Description: This method sets the format for each question asked.
    //
    // Parameters: N/A
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void questions() {
        int a = num.nextInt(numlimit);
        int b = num.nextInt(numlimit);
        int i = 1;

        System.out.println("\nWhat is " + a + " times " + b + "?");
        int input = ans.nextInt();

        while (input != a * b) {
            System.out.println(negative_responses[i % 5]);
            System.out.println("\nWhat is " + a + " times " + b + "?");
            input = ans.nextInt();
            i++;
        }
        System.out.println(positive_responses[i % 5] + "\n");
    }

    // ***************************************************************
    //
    // Method: test
    //
    // Description: This method formats the test in terms of amount of questions
    // asked and deciding when to stop the test according to parameters set.
    //
    // Parameters: N/A
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void test() {
        String choice = "y";
        int i = 0;

        while (choice.equals("y")) {

            // Iterate:
            i++;
            questions();

            // Stop the test after 5 questions if the user answers "n", but continue if "y".
            // If answer is "y" after first 5 correct answers, they will have the option to
            // quit after every problem.
            if (i >= 4) {
                System.out.print("Great job.\nWould you like to continue? (y/n): ");
                choice = ans.next();
            }
        }
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
        System.out.println("Program: Eight \n");
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
    } // End of developerInfo
}