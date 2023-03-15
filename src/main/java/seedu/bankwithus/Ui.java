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
        System.out.println("The input is not a valid number! Please try again.");
    }

    public void showNullInputError() {
        System.out.println("The input cannot be empty! Please try again.");
    }

    public void showCommandNotFoundError() {
        System.out.println("Not a valid command!");
    }

    public void showFarewellMessage() {
        System.out.println("Goodbye! Hope to see you again! :)");
    }

    public void showDepositMessage() {
        System.out.println("New deposit added!");
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

    public void printLine() {
        System.out.println("----------------------------");
    }

    public void viewAccount(String accDetails) {
        String name = accDetails.split(";")[0];
        String bal = accDetails.split(";")[1];
        printLine();
        System.out.println("Name: " + name);
        System.out.println("Balance: $" + bal);
        printLine();
    }

    public void showBal(float finalBal) {
        System.out.println("You have $" + String.valueOf(finalBal) + " remaining!");
    }

    public void showNegativeAmountError() {
        System.out.println("Negative number entered!");
    }

    public void showInsufficientBalanceMessage() {
        System.out.println("You do not have sufficient Balance");
    }
}
