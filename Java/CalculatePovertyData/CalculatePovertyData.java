//********************************************************************
//
//  Author:        Denver Clark
//
//  Program #:     Ten
//
//  File Name:     Program10.java
//
//  Course:        ITSE 2321 Object-Oriented Programming
//
//  Due Date:      7/25/2022
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       Chapters 8-9
//
//  Description:   Write a program to read the survey results into an ArrayList, created in the main class,
//  and perform the following analysis. 
//  
//  a) Print the record of each household included in the survey in a four-column format
//  with headings. The four-digit integer identification number, the annual income for
//  the household, the number of household members, and the state of the household.
//  b) Calculate and print the average household income.
//  c) List the identification number, income, members, and state of the households that
//  exceed the average in a four-column format with headings.
//  d) Determine and print the identification number, income, poverty level, members, and
//  state of the households, in a five-column format with headings, that have income
//  below the 2022 United States poverty level.
//  e) Determine and print the percentage of households that have income below the
//  2022 United States Federal Poverty Level (FPL).
//  f) There are several programs, including Medicaid, that use a percentage of the
//  Federal Poverty Level (FPL) as the income criteria for program participation. The
//  exact percentage of the FPL used for eligibility purposes varies based on the
//  program and the state. For example, many states use 138% of the FPL for
//  Medicaid eligibility. Assuming all the 50 states use this percentage, determine and
//  print the percentage of households that would qualify for Medicaid.
//  
//
//********************************************************************

// Imports:
import java.text.DecimalFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Main Test Class *******************************************
// HouseHold Class begins around LINE 260 ********************
public class Program10 {

    // Creates a HouseHold ArrayList where inputs read for each line of data will be
    // stored.
    ArrayList<HouseHold> houseHolds;

    // Constructor
    public Program10() {
        houseHolds = new ArrayList<>();
    }

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
        // declare variables here:
        // (None)

        // Create object:
        Program10 householdData = new Program10();

        // Stop the program if errors are caught / print trace.
        try {
            // Create the file object and read the file
            File inputFile = new File("HouseholdData.txt");
            householdData.readFile(inputFile);

            // Create output file and FileWriter object to write to the specified output
            // file
            FileWriter outputFile = new FileWriter("PovertyDataFormatted.txt");
            PrintWriter writer = new PrintWriter(outputFile);

            // Print data of all households
            householdData.printAll(writer);

            // Print data of all households whose income is more than average household
            // income
            householdData.printAboveAverage(writer);

            // Print all households below poverty level
            householdData.printBelowPovertyLevel(writer);

            // Closing the writer to avoid errors
            writer.close();

        } catch (Exception e) {
            // Print exception/error and stack trace of the error if scanner does not get
            // correct input type
            e.printStackTrace();
        }

        // Run developer info method at the end of the program
        developerInfo();

    } // End of the main method

    // Method to read file and store data to houseHolds ArrayList
    public void readFile(File inputFile) throws Exception {
        // Create a Scanner object to scan the file
        Scanner scanner = new Scanner(inputFile);

        // Scan the data in the order given within the input file.
        while (scanner.hasNext()) {
            int id = scanner.nextInt();

            double income = scanner.nextDouble();

            int members = scanner.nextInt();

            String state = scanner.next();

            // Clear buffer
            scanner.nextLine();

            // Add the record to the ArrayList
            houseHolds.add(new HouseHold(id, income, members, state));
        }

        scanner.close();

    }

    // ***************************************************************
    //
    // Method: printAll()
    //
    // Description: Prints and writes all records entered in formatted form to the
    // terminal as well as the output file.
    //
    // Parameters:
    //
    // Returns: N/A
    //
    // **************************************************************
    public void printAll(PrintWriter writer) {
        System.out.println(
                "\n\n\nThe following data was read by the scanner and formatted accordingly.\n\nThe data will be found in an output file titled: 'PovertyDataFormatted.txt'.\n\n\n");
        System.out.printf("\t %-15s%-15s%-10s%-12s\n\n", "ID", "Amount", "Members",
                "State");
        writer.printf(
                "\n\n\nFamily Income Information of Input File:\nHouseholdData.txt\n\n\n"
                        + "\t %-15s%-15s%-11s%-12s\n\n",
                "ID", "Amount", "Members", "State");
        for (HouseHold home : houseHolds) {
            System.out.println(home.returnRecord());
            writer.println(home.returnRecord());
        }
        System.out.println("\n\n");
    }

    // ***************************************************************
    //
    // Method: printAboveAverage()
    //
    // Description: Prints above average income records
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public void printAboveAverage(PrintWriter writer) {
        double totalIncome = 0;

        // Calculate the average income of households
        for (HouseHold home : houseHolds) {
            totalIncome += home.getIncome();
        }
        double avgIncome = totalIncome / houseHolds.size();

        // Format and write the average income to output file
        DecimalFormat f = new DecimalFormat("###,###.00");
        writer.println("\n\nFamilies above the average income of $" + f.format(avgIncome) + "\n");
        writer.printf("\t %-15s%-15s%-11s%-12s\n\n", "ID", "Amount", "Members", "State");

        // Write the households data when the income is more than the current average
        for (HouseHold home : houseHolds) {
            if (home.getIncome() > avgIncome)
                writer.println(home.returnRecord());
        }
    }

    // ***************************************************************
    //
    // Method: printBelowPovertyLevel
    //
    // Description: The developer information method of the program
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public void printBelowPovertyLevel(PrintWriter writer) {
        // Counter to count households below poverty level
        double count = 0;

        writer.println("\n\nFamilies below the 2022 poverty level:\n");
        writer.printf("       %s\n", "Poverty");
        writer.printf("\t%-19s%-15s%-15s%-9s%-12s\n\n", "Level", "ID", "Amount", "Members", "State");

        DecimalFormat f = new DecimalFormat("###,###.00");
        // Print all households below poverty level
        for (HouseHold home : houseHolds) {
            if (home.getIncome() < home.getPovertyLevel()) {
                writer.println(
                        String.format("      %-12s%s", "$" + f.format(home.getPovertyLevel()), home.returnRecord()));
                count++;
            }
        }

        // Format percentage below poverty level before printing it
        System.out.println(
                "Percentage of families below poverty level: " + f.format((count / houseHolds.size()) * 100)
                        + "%\n\n\n");

        // Format percentage below poverty level before writing it to the output file.
        writer.println(
                "\nPercentage below the 2022 poverty level is: " + f.format((count / houseHolds.size()) * 100)
                        + "%\n\n\n");
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
        System.out.println("Program: Ten \n");
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
    } // End of developerInfo
}

// HouseHold Class ***************************************
class HouseHold {
    int id;
    double income;
    int numberOfMembers;
    String state;
    double povertyLevel;

    // HouseHold constructor:
    public HouseHold(int id, double income, int numberOfMembers, String state) {
        this.id = id;
        this.income = income;
        this.numberOfMembers = numberOfMembers;
        this.state = state;
        calculatePovertyLevel();
    }

    // ***************************************************************
    //
    // Method: calcPovertyLevel()
    //
    // Description: This method calculates the poverty level of each state and has
    // specific instances for HI and AK.
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    private void calculatePovertyLevel() {
        if (state.equals("Alaska"))
            povertyLevel = 21550 + 5600 * (numberOfMembers - 2);
        else if (state.equals("Hawaii"))
            povertyLevel = 19830 + 5150 * (numberOfMembers - 2);
        else
            povertyLevel = 17240 + 4480 * (numberOfMembers - 2);
    }

    // ***************************************************************
    //
    // Method: returnRecord()
    //
    // Description: This method formats the data and returns it into a formated
    // String format
    //
    // Parameters: None
    //
    // Returns: String type
    //
    // **************************************************************
    public String returnRecord() {
        DecimalFormat f = new DecimalFormat("###,###.00");
        return String.format("%12d%20s%12d\t%-20s", id, "$" + f.format(income), numberOfMembers, state);
    }

    // ***************************************************************
    //
    // Method: getIncome()
    //
    // Description: Return income for each set of data
    //
    // Parameters: None
    //
    // Returns: double income
    //
    // **************************************************************
    public double getIncome() {
        return income;
    }

    // ***************************************************************
    //
    // Method: getPovertyLevel()
    //
    // Description: Returns poverty level for each set of data
    //
    // Parameters: None
    //
    // Returns: double
    //
    // **************************************************************
    public double getPovertyLevel() {
        return povertyLevel;
    }

}