// Part 2: Ticket Categories
// 10 fans select their ticket preferences. Some pick the same category multiple times.

// Write a Java program that:

// Takes 10 strings as input (ticket types like "VIP", "General", "Standing", etc.)
// Adds them to an ArrayList (to see all selections)
// Adds them to a HashSet (to see unique categories)
// Creates a HashMap with category name as key and count as value
// Prints all three collections
// Example Input:

// VIP, General, VIP, Standing, Seated, VIP, General, Standing, Premium, VIP
// Example Output:

// ArrayList: [VIP, General, VIP, Standing, Seated, VIP, General, Standing, Premium, VIP]

// HashSet: [VIP, General, Standing, Seated, Premium]

// HashMap: {VIP=4, General=2, Standing=2, Seated=1, Premium=1}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Part_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        // Taking 10 inputs
        System.out.println("Enter 10 ticket categories:");
        for (int i = 0; i < 10; i++) {
            String ticket = sc.nextLine();
            list.add(ticket);      // Add to ArrayList
            set.add(ticket);       // Add to HashSet

            // Add to HashMap (count occurrences)
            map.put(ticket, map.getOrDefault(ticket, 0) + 1);
        }

        // Printing all collections
        System.out.println("\nArrayList: " + list);
        System.out.println("HashSet: " + set);
        System.out.println("HashMap: " + map);

        sc.close();
    }    
}
