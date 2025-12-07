// Part 1: Username Checker
// A fan registers for tickets by entering their username twice. Check if they match.

// Write a Java program that:

// Takes two strings as input (username and confirmation)
// Prints the length of the first string
// Prints the length of the second string
// Prints if the lengths match
// Prints if the two strings are the same
// Example:

// Input: "kduRocker2026" and "kduRocker2026"
// Output:
// Length 1: 11
// Length 2: 11
// Lengths match: true
// Strings match: true

import java.util.Scanner;

public class Part_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Confirm username: ");
        String confirmation = sc.nextLine();;

        System.out.println("Length 1: " + username.length());
        System.out.println("Length 2: " + confirmation.length());
        System.out.println("Lengths match: " + (username.length() == confirmation.length()));
        System.out.println("Strings match: " + username.equals(confirmation));
        sc.close();
    }
}
