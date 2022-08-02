import java.util.ArrayList;
import java.util.Scanner;

class PrimeDirective {

    // This method checks if the entered number is a prime number or not
    public boolean isPrime() {

        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\nEnter a number to check if it is prime or not: \n");
        int number = input.nextInt();
        input.close();

        if (number == 2) {
            // Is smallest prime number
            System.out.println("\nYes. This number is prime.\n");
            return true;
        }
        if (number < 2) {
            // Is not prime
            System.out.println("\nNo. This number is NOT prime.\n");
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println("\nNo. This number is NOT prime.\n");
                return false;
            }
        }
        System.out.println("\nYes. This number is prime.\n\n\n\n\n");
        return true;
    }

    public ArrayList<Integer> onlyPrimes(int[] numbers) {
        ArrayList<Integer> primes = new ArrayList<Integer>();

        // Adds a number to the onlyPrimes list if the number
        // returns "true" when passed through the isPrime() method
        for (Integer number : numbers) {
            if (true) {
                primes.add(number);
            }
        }
        return primes;
    }

    public static void main(String[] args) {

        // Creating a new PrimeDirective object
        PrimeDirective pd = new PrimeDirective();

        // Test array list "primes":
        // int[] numbers = { 1, 2, 3 };

        // ***** Run *****
        pd.isPrime();

        // ArrayList of **only prime numbers** that have been
        // listed within the numbers[] integer array:
        // System.out.println("Current Prime Numbers in Array:\n------------\n\n" +
        // pd.onlyPrimes(numbers) + "\n\n");
    }
}