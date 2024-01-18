// This Java program checks whether a given number is a Smith Number or not.
// A Smith Number is a positive integer for which the sum of its digits is equal to the sum of the digits of its prime factors.
// (c) Aritro "ars3n1c" Shome
import java.util.Scanner;

// Class definition for the Smith class
class Smith {
    // Private member variable to store the input number
    private int number;

    // Default constructor initializing the number to zeros
    Smith() {
        this.number = 0;
    }

    // Method to take user input for a positive natural number
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number = ");

        try {
            // Try to read an integer from the user
            this.number = sc.nextInt();
        } catch (Exception e) {
            // Handle the exception if the input is not a valid integer
            System.out.println("Invalid input. Try again with a positive natural number.");
            // Recursive call to input() method to prompt the user again
            this.input();
        }

        // Check if the entered number is negative and prompt the user again if so
        if (this.number < 0) {
            System.out.println("Invalid input. Try again with a positive natural number.");
            // Recursive call to input() method to prompt the user again
            this.input();
        }
    }

    // Private method to calculate the sum of digits of a given number
    private int sumOfDigits(int num) {
        int sum = 0;
        // Loop to extract each digit and add it to the sum
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    // Private method to check if a number is prime
    private boolean isPrime(int f) {
        int c = 0;
        // Loop to count the factors of the given number
        for (int i = 1; i <= f; ++i) {
            c += (f % i == 0) ? 1 : 0;
        }
        // If the number has exactly two factors, it is prime
        return c == 2;
    }

    // Public method to check if the current number is a Smith Number
    public boolean isSmith() {
        int sum = 0;
        // Loop to iterate through each number from 2 to the input number
        for (int i = 2; i <= this.number; ++i) {
            if (isPrime(i)) {
                int count = 0, backup = this.number;
                // Check if 'i' is a prime factor of the input number
                while (backup % i == 0) {
                    backup /= i;
                    ++count;
                }
                // Add the product of the count and the sum of digits of 'i' to the total sum
                sum += count * sumOfDigits(i);
            }
        }
        // Check if the sum of digits of the prime factors is equal to the sum of digits of the original number
        return sum == sumOfDigits(this.number);
    }

    // Main method where the program execution begins
    public static void main(String[] args) {
        // Create an object of the Smith class
        Smith obj = new Smith();
        // Call the input method to get the user input
        obj.input();
        
        // Check if the entered number is a Smith Number and display the result
        if (obj.isSmith())
            System.out.println("Yes, it's a Smith Number");
        else
            System.out.println("No, it's not a Smith Number");
    }
}
