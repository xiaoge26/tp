package seedu.bankwithus;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Account {
    private String name;
    private String balance;
    private String totalAmtWithdrawn;
    private LocalDate lastWithdrawnDate;

    //@@author Sherlock-YH
    /**
     * Instantiates an account object
     *
     * @param name    initialise in the name of the account
     * @param balance initialise the balance of the account
     */
    public Account(String name, String balance) {
        this.name = name;
        this.balance = balance;
    }
    //@@author Sherlock-YH
    public String getAccountName() {
        return name;
    }
    //@@author Sherlock-YH
    public String getAccountBalance() {
        return balance;
    }
    //@@author
    public void addBalance(float balanceToBeAdded) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(Float.parseFloat(balance) + balanceToBeAdded);
        this.balance = String.valueOf(formatted);
    }

    public void subtractBalance(float currentBalance, float withdrawal) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(currentBalance - withdrawal);
        this.balance = String.valueOf(formatted);
        updateTotalAmtWithdrawn(withdrawal);
    }

    //@@author tyuyang
    private void updateTotalAmtWithdrawn(float withdrawal) {
        LocalDate currentDate = LocalDate.now();
        DecimalFormat df = new DecimalFormat("#.##");
        if (lastWithdrawnDate == null) {
            lastWithdrawnDate = currentDate;
            String formatted = df.format(withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
            return;
        }
        assert totalAmtWithdrawn != null;
        if (lastWithdrawnDate.getMonth() == currentDate.getMonth() && 
                lastWithdrawnDate.getYear() == currentDate.getYear()) {
            String formatted = df.format(Float.parseFloat(totalAmtWithdrawn) + withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
        } else {
            String formatted = df.format(withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
        }
        lastWithdrawnDate = currentDate;
    }
}
