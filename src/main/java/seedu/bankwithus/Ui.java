package seedu.bankwithus;

public class Ui {

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

    public void showFarewellMessage() {
        System.out.println("Goodbye! Hope to see you again! :)");
    }
}
