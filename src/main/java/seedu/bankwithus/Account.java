package seedu.bankwithus;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Account {
    private String name;
    private String balance;
    private WithdrawalChecker withdrawalChecker;

    private float amtToSave = 0;

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
        this.withdrawalChecker = new WithdrawalChecker();
    }

    //@@author tyuyang
    public Account(String name, String balance, String totalAmtWithdrawn,
            LocalDate lastWithdrawnDate) {
        this.name = name;
        this.balance = balance;
        this.withdrawalChecker = new WithdrawalChecker(totalAmtWithdrawn, lastWithdrawnDate);
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

        withdrawalChecker.updateTotalAmtWithdrawn(withdrawal);
    }
}
