package seedu.bankwithus;

import seedu.bankwithus.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    private ArrayList<Account> accounts;
    private BankWithUs bwu;
    private Ui ui;
    
    public AccountList(BankWithUs bwu) {
        accounts = new ArrayList<Account>();
        this.bwu = bwu;
        this.ui = bwu.getUi();
        createNewAccount();
    }

    public AccountList(Scanner scanner, BankWithUs bwu) {
        accounts = new ArrayList<Account>();
        this.bwu = bwu;
        this.ui = bwu.getUi();
        Parser parser = new Parser(this);
        try {
            parser.parseSavedFile(scanner);
        } catch (Exception e) {
            ui.showCorruptedSaveFileError();
            createNewAccount();
        }
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
            if (balance < 0) {
                ui.showNegativeAmountError();
                return askUserForBalance();
            }
            return balance;
        } catch (NumberFormatException e) {
            ui.showNumberFormatError();
            return askUserForBalance();
        }
    }

    /**
     * Creates a new account and adds it to the AccountList.
     *
     * @param name      Name of the new account to be added
     * @param balance   Balance of the new account to be added
     */
    public void addAccount(String name, float balance) {
        Account newAccount = new Account(name, balance);
        accounts.add(newAccount);
    }

    /**
     * Creates a new Account for a first time user
     */
    public void createNewAccount() {
        String userName = askUserForName();
        float balance = askUserForBalance();
        addAccount(userName, balance);
    }

    /**
     * name and balance are separated by ; prepared to be saved
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
