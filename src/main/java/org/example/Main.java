package org.example;

import parts.Catalog;
import parts.Storage;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // System.out.printf("Hello and welcome!");

        Storage storage = new Storage();

        Catalog cat = storage.getCatalog();

        Scanner scanner;
        String choice;

        do {
            //Runtime.getRuntime().exec("clear");
            System.out.println();
            System.out.println("Product Catalog");
            System.out.println("1. View All Products");
            System.out.println("2. Filter Products by Catalog");
            System.out.println("3. Filter Products by Price");
            System.out.println("4. Request Products Installation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            scanner = new Scanner(System.in);
            //scanner = new Scanner(System.in);
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cat.viewAllProducts();
                    break;
                case "2":
                    cat.filterProductsByCatalog(scanner);
                    break;
                case "3":
                    cat.filterProductsByPrice();
                    break;
                case "4":
                    cat.requestInstallation(scanner);
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();

    }
}