//********************************************************************
//
//  Author:        Denver Clark
//
//  Program #:     Nine
//
//  File Name:     Program9.java
//
//  Course:        ITSE 2321 Object-Oriented Programming
//
//  Due Date:      7/21/2022
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       8-9
//
//  Description:   This program is made to create savings accounts for clients,
//                 check balances, deposit, withdraw, and set savings interest rates.
//
//********************************************************************
public class Program9 {

    public void Program9(SavingsAccount saver1) {
    }

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

        // Create 2 accounts.
        SavingsAccount saver1, saver2;
        saver1 = new SavingsAccount(2000.0);
        saver2 = new SavingsAccount(3000.0);

        SavingsAccount.modifyInterestRate(0.04);
        int total_month = 12; // Sets count amount to 12 for month incrementation

        double[] balance_month = saver1.getMonthsSavingBalance(total_month); // Input number of months to calculate in
                                                                             // function params.
        System.out.println("*********************************************************************");
        for (int i = 0; i < total_month; i++) {
            System.out.println(
                    "\n Month " + (i + 1) + ":\n Saver 2 Balance: " + balance_month[i]
                            + " at an accrual rate of 0.04\n");
        }
        System.out.println("*********************************************************************");
        balance_month = saver2.getMonthsSavingBalance(12);
        for (int i = 0; i < total_month; i++) {
            System.out.println(
                    "\n Month " + (i + 1) + ":\n Saver 2 Balance: " + balance_month[i]
                            + " at an accrual rate of 0.04\n");
        }
        System.out.println("*********************************************************************");
        SavingsAccount.modifyInterestRate(0.05);
        balance_month = saver1.getMonthsSavingBalance(12);
        for (int i = 0; i < total_month; i++) {
            System.out.println(
                    "\n Month " + (i + 1) + ":\n Saver 1 Balance: " + balance_month[i]
                            + " at an accrual rate of 0.05\n");
        }
        System.out.println("*********************************************************************");
        balance_month = saver2.getMonthsSavingBalance(12);
        for (int i = 0; i < total_month; i++) {
            System.out.println(
                    "\n Month " + (i + 1) + ":\n Saver 2 Balance: " + balance_month[i]
                            + " at an accrual rate of 0.05\n");
        }
        System.out.println("*********************************************************************");

        developerInfo();
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
        System.out.println("Program: Nine \n");
        System.out.println(
                "-------------------------------------------------------------------------------------------\n");
    } // End of developerInfo
}

class SavingsAccount {

    // Variables:
    static private double annualInterestRate;
    private double savingBalance;

    // Constructor method
    public SavingsAccount() {
        this.savingBalance = 0;
    }

    // Constructor method
    public SavingsAccount(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    // Get saving balance
    public double getSavingBalance() {
        return this.savingBalance;
    }

    // ***************************************************************
    //
    // Method: getMonthlySavingBalance
    //
    // Description: Iterates through a specified amount of months while calculating
    // in interest accrued and returning a new balance.
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public double[] getMonthsSavingBalance(int total_months) {
        double[] monthlyI_month = new double[total_months];
        double monthlyI;
        for (int i = 0; i < total_months; i++) {
            monthlyI = (double) (this.savingBalance * annualInterestRate / 12);
            this.savingBalance += monthlyI;
            monthlyI_month[i] = this.savingBalance;
        }
        return monthlyI_month;
    }

    // Sets annual interest rate to a new value
    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    // Calculate monthly interest
    public void calculateMonthlyInterest() {
        double monthlyI;
        monthlyI = (double) (this.savingBalance * annualInterestRate / 12);
        this.savingBalance += monthlyI;
    }
}