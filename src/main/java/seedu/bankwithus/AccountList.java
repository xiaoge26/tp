package seedu.bankwithus;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    protected ArrayList<Account> accounts;
    private Ui ui;

    public AccountList() {
        accounts = new ArrayList<Account>();
    }

    public AccountList(Scanner scanner) {
        accounts = new ArrayList<Account>();
    }

    /**
     * Creates a new account and adds it to the AccountList.
     *
     * @param name          Name of the new account to be added
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

    /**
     * name and balance are separated by $ prepared to be saved
     *
     * @return returns all accounts details in String
     */
    public String getAllAccountDetails() {
        String temp = "";
        for (Account acc : accounts) {
            temp += acc.name + "$" + acc.balance;
            temp += "\n";
        }
        return temp;
    }
}
