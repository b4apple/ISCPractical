// This Java program checks whether a given number is a Fascinating Number or not.
// A Fascinating Number is one whose concatenation with its multiples (2 times and 3 times) contains all digits exactly once.
// (c) Aritro "ars3n1c" Shome
import java.util.Scanner;

// Class definition for the Fascinating class
class Fascinating {
    // Private member variable to store the input number
    private int number;

    // Default constructor initializing the number to zero
    Fascinating() {
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

    // Method to check if the current number is a Fascinating Number
    public boolean isFascinating() {
        // Array to track the presence of each digit (0 to 9)
        boolean[] present = new boolean[10];
        // Concatenate the number with its multiples (2 times and 3 times)
        String num = this.number + "" + (this.number * 2) + "" + (this.number * 3);
        int len = num.length();

        // Check if the concatenated string has exactly 9 digits
        if (len == 9) {
            // Iterate through each digit in the concatenated string
            for (int i = 0; i < num.length(); ++i)
                present[num.charAt(i) - 48] |= true; // Set the corresponding index in the array to true

            // Check if all digits from 1 to 9 are present exactly once
            boolean ret = true;
            for (int i = 1; i < 10; ++i)
                ret &= present[i];

            return ret;
        } else {
            // If the concatenated string doesn't have exactly 9 digits, it's not fascinating
            return false;
        }
    }

    // Main method where the program execution begins
    public static void main(String[] args) {
        // Create an object of the Fascinating class
        Fascinating obj = new Fascinating();
        // Call the input method to get the user input
        obj.input();

        // Check if the entered number is a Fascinating Number and display the result
        if (obj.isFascinating())
            System.out.println("Yes, Fascinating.");
        else
            System.out.println("No, not Fascinating.");
    }
}
