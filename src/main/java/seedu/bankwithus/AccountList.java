package seedu.bankwithus;

import seedu.bankwithus.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    protected ArrayList<Account> accounts;
    private Ui ui;

    public AccountList() {
        accounts = new ArrayList<Account>();
        ui = new Ui();
        createNewAccount();
    }

    public AccountList(Scanner scanner) {
        accounts = new ArrayList<Account>();
        ui = new Ui();
    }

    private String askUserForName() {
        ui.askForName();
        String userName = ui.getNextLine();
        userName.trim();
        if (userName.isBlank()) {
            ui.showBlankUserNameError();
            return askUserForName();
        }
        return userName;
    }

    private float askUserForBalance() throws NumberFormatException {
        ui.askForBalance();
        String balanceString = ui.getNextLine();
        balanceString.trim();
        try {
            float balance = Float.parseFloat(balanceString);
            return balance;
        } catch (NumberFormatException e) {
            return askUserForBalance();
        }
    }

    /**
     * Creates a new account and adds it to the AccountList.
     *
     * @param name          Name of the new account to be added
     * @param balance Balance of the new account to be added
     */
    public void addAccount(String name, float balance) {
        Account newAccount = new Account(name, balance);
        accounts.add(newAccount);
    }

    /**
     * Creates a new Account for a first time user
     */
    public void createNewAccount() {
        ui.createScanner();
        String userName = askUserForName();
        float balance = askUserForBalance();
        addAccount(userName, balance);
        ui.closeScanner();
    }

    /**
     * name and balance are separated by $ prepared to be saved
     *
     * @return returns all accounts details in String
     */
    public String getAllAccountDetails() {
        String temp = "";
        for (Account acc : accounts) {
            temp += acc.name + ";" + acc.balance;
            temp += "\n";
        }
        return temp;
    }

    public Account getCurrentAccount() {
        return accounts.get(0);
    }

    public void depositMoney(String depositAmountString) throws NumberFormatException,
            NullPointerException, NegativeAmountException {
        float depositAmount = Float.parseFloat(depositAmountString);
        if (depositAmount < 0) {
            throw new NegativeAmountException();
        } else {
            getCurrentAccount().balance += depositAmount;
        }
    }
}
