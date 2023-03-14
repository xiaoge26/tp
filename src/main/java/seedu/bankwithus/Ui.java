package seedu.bankwithus;

import java.util.Scanner;

public class Ui {

    private Scanner scanner;

    public void showFileNotFoundError() {
        System.out.println("File not found, trying to create file.");
    }

    public void showFileCreated() {
        System.out.println("Savefile created successfully!");
    }

    public void showIOError() {
        System.out.println("Something's really wrong! Exiting program now.");
    }

    public void showNumberFormatError() {
        System.out.println("The input is not a number! Please try again.");
    }

    public void showCommandNotFoundError() {
        System.out.println("Not a valid command!");
    }

    public void showFarewellMessage() {
        System.out.println("Goodbye! Hope to see you again! :)");
    }

    /**
     * Creates a scanner in the Ui class
     */

    public void createScanner() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Gets the next line of user input
     * 
     * @return the next of user input
     */

    public String getNextLine() {
        return scanner.nextLine();
    }

    /**
     * Closes the scanner
     */

    public void closeScanner() {
        this.scanner.close();
    }

    public void viewAccount(String accDetails) {
        String name = accDetails.split(";")[0];
        String bal = accDetails.split(";")[1];
        System.out.println("----------------------------");
        System.out.println("Name: " + name);
        System.out.println("Balance: $"+bal);
        System.out.println("----------------------------");
    }
}
