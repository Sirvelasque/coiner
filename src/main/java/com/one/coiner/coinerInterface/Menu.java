package com.one.coiner.coinerInterface;

import Client.CoinConverter;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
        render();
    }

    private void render() {
        System.out.println("Welcome to the Currency Converter!");

        String[] options = {"USD", "EUR", "JMD", "RUB"};

        // Ask for the base currency
        System.out.println("Select the base currency to convert from:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        int baseIndex = getUserOption(options.length);
        String baseCurrency = options[baseIndex - 1];

        // Ask for the target currency
        System.out.println("Select the target currency to convert to:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        int targetIndex = getUserOption(options.length);
        String targetCurrency = options[targetIndex - 1];

        // Ask for the amount to convert
        System.out.println("Enter the amount to convert:");
        double amount = getUserAmount();

        // Perform conversion
        CoinConverter converter = new CoinConverter();
        double rate = converter.convert(baseCurrency, targetCurrency, amount);

        // Display result
        System.out.println(amount + " " + baseCurrency + " is " + rate + " " + targetCurrency);

        // Close the scanner
        scanner.close();
    }

    private int getUserOption(int maxOption) {
        int option = 0;
        while (option < 1 || option > maxOption) {
            System.out.print("Enter your choice (1-" + maxOption + "): ");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 1 || option > maxOption) {
                    System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return option;
    }

    private double getUserAmount() {
        double amount = 0;
        while (amount <= 0) {
            System.out.print("Enter a positive amount: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Amount must be positive. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        new Menu();
    }
}
