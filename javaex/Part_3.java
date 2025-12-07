// Part 3: Popular Merchandise
// A CSV file contains merchandise items bought by fans. Find the top 3 most popular items.

// Write a Java program that:

// Reads a CSV file with comma-separated merchandise names
// Counts how many times each item appears
// Prints the top 3 items with their counts
// Sample CSV file (items.csv):

// tshirt, poster, hoodie, album, tshirt, poster, hoodie, album, tshirt, poster, hoodie, album, tshirt, poster, tshirt, poster, tshirt
// Hint: Use Scanner to read the file, split(",") to separate items, and HashMap to count

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part_3 {
    public static void main(String[] args) {
        // Change this path if needed
        String fileName = "items.csv";

        HashMap<String, Integer> countMap = new HashMap<>();

        try {
            Scanner sc = new Scanner(new File(fileName));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] items = line.split(",");

                for (String item : items) {
                    item = item.trim(); // remove spaces

                    countMap.put(item, countMap.getOrDefault(item, 0) + 1);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // Convert to list for sorting
        List<Map.Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());

        // Sort by decreasing count
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print top 3
        System.out.println("Top 3 Most Popular Items:");
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

