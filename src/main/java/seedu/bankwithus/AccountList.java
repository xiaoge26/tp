package seedu.bankwithus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    protected ArrayList<Account> accounts;
    public Ui ui;

    public AccountList() {
    }

    /**
     * Creates a new account and adds it to the AccountList.
     *
     * @param name Name of the new account to be added
     * @param balanceString Balance of the new account to be added in String type
     * @throws NumberFormatException If balanceString cannot be parsed into a float number
     */
    public void addAccount(String name, String balanceString) throws NumberFormatException {
        try {
            float balance = Float.parseFloat(balanceString);
            Account newAccount = new Account(name, balance);
            accounts.add(newAccount);
        } catch (NumberFormatException e) {
            ui.showNumberFormatError();
        }
    }
    
    public AccountList(Scanner scanner) {

    }
}
