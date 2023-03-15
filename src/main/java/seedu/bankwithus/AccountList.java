package seedu.bankwithus;

import seedu.bankwithus.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
    protected ArrayList<Account> accounts;

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
    public void addAccount(String name, String balanceString) throws NumberFormatException, NullPointerException {
        float balance = Float.parseFloat(balanceString);
        Account newAccount = new Account(name, balance);
        accounts.add(newAccount);
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
