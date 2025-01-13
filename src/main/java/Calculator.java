import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Initialize the scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Flag to control the main loop
        boolean continueCalculating = true;
        // Variable to store the current result
        double currentResult = 0.0;
        // Flag to indicate if a valid result exists
        boolean hasResult = false;

        // Welcome message
        System.out.println("Welcome to the Java Calculator!");

        // Main loop for the calculator
        while (continueCalculating) {
            // Display the menu of operations
            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Reset current result");
            System.out.println("6. Exit");

            // Read the user's choice
            int choice = scanner.nextInt();

            // Exit the program if the user selects 6
            if (choice == 6) {
                System.out.println("Thank you for using the calculator. Goodbye!");
                break;
            }

            // Reset the current result if the user selects 5
            if (choice == 5) {
                currentResult = 0.0;
                hasResult = false;
                System.out.println("Current result has been reset.");
                continue; // Skip the rest of the loop and display the menu again
            }

            double num1;

            // If there is a valid result, use it as the first number
            if (hasResult) {
                System.out.println("Current result: " + currentResult);
                System.out.print("Enter the next number: ");
                num1 = currentResult;
            } else {
                // Otherwise, prompt the user for the first number
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();
            }

            // Prompt the user for the second number
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Perform the chosen operation
            switch (choice) {
                case 1: // Addition
                    currentResult = num1 + num2;
                    System.out.println("Result: " + currentResult);
                    hasResult = true;
                    break;
                case 2: // Subtraction
                    currentResult = num1 - num2;
                    System.out.println("Result: " + currentResult);
                    hasResult = true;
                    break;
                case 3: // Multiplication
                    currentResult = num1 * num2;
                    System.out.println("Result: " + currentResult);
                    hasResult = true;
                    break;
                case 4: // Division
                    if (num2 != 0) {
                        currentResult = num1 / num2;
                        System.out.println("Result: " + currentResult);
                        hasResult = true;
                    } else {
                        // Handle division by zero
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please select a valid operation.");
            }

            // Ask the user if they want to continue
            System.out.println("Do you want to perform another operation? (yes/no): ");
            String continueChoice = scanner.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                // Exit the loop if the user says "no"
                continueCalculating = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
            }
        }

        // Close the scanner resource
        scanner.close();
    }
}