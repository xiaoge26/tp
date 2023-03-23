package seedu.bankwithus;

import java.text.DecimalFormat;

public class Account {
    private String name;
    private String balance;

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

    public String getAccountName() {
        return name;
    }

    public String getAccountBalance() {
        return balance;
    }

    public void addBalance(float balanceToBeAdded) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(Float.parseFloat(balance) + balanceToBeAdded);
        this.balance = String.valueOf(formatted);
    }

    public void subtractBalance(float currentBalance, float withdrawal) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(currentBalance - withdrawal);
        this.balance = String.valueOf(formatted);
    }
}
