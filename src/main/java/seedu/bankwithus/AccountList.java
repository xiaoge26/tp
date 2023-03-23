package seedu.bankwithus;

import seedu.bankwithus.exceptions.AccountNotFoundException;
import seedu.bankwithus.exceptions.CorruptedSaveFileException;
import seedu.bankwithus.exceptions.InsufficientBalanceException;
import seedu.bankwithus.exceptions.NegativeAmountException;
import seedu.bankwithus.exceptions.NoAccountException;
import seedu.bankwithus.exceptions.SaveFileIsEmptyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AccountList {
    private ArrayList<Account> accounts;
    private Ui ui;

    /**
     * Instantiates AccountList and creates a new account.
     * Called only when savefile is not found
     *
     * @param bwu the main bankWithUs program
     */
    public AccountList(BankWithUs bwu) {
        accounts = new ArrayList<Account>();
        this.ui = bwu.getUi();
        createNewAccount();
    }

    /**
     * Instantiates AccountList and either:
     * 1. Load the saved information in the save file into
     * the account list
     * 2. Create a brand new account if the save file was
     * empty
     *
     * @param scanner the scanner containing the information in the save file
     * @param bwu     the main bankWithUs program
     */
    public AccountList(Scanner scanner, BankWithUs bwu) {
        accounts = new ArrayList<>();
        this.ui = bwu.getUi();
        Parser parser = new Parser(this);
        try {
            parser.parseSavedFile(scanner);
        } catch (CorruptedSaveFileException e) {
            ui.showCorruptedSaveFileError();
            createNewAccount();
        } catch (SaveFileIsEmptyException e) {
            ui.showEmptyFile();
            createNewAccount();
        }
    }

    /**
     * Returns the current account.
     *
     * @return
     */
    public Account getMainAccount() {
        return accounts.get(0);
    }

    /**
     * Asks the user for the name and returns it in the form of
     * a string. Will keep looping so long as the user does not
     * give a valid name
     *
     * @return the userName String
     */
    private String askUserForName() {
        ui.askForName();
        String userName = ui.getNextLine();
        userName.trim();
        if (userName.isBlank()) {
            ui.showBlankUserNameError();
            return askUserForName();
        }
        if (userName.contains(";")) {
            ui.showForbiddenCharacterError();
            return askUserForName();
        }
        return userName;
    }

    /**
     * Asks the user for their initial balance and returns it as a
     * float. Will keep looping so long as the user does not give
     * a valid balance.
     *
     * @return balance in the form of a float
     */
    private String askUserForBalance() {
        ui.askForBalance();
        String balanceString = ui.getNextLine();
        balanceString = balanceString.trim();
        try {
            float balance = Float.parseFloat(balanceString);
            if (balance < 0) {
                throw new NegativeAmountException();
            }
            return balanceString;
        } catch (NumberFormatException e) {
            ui.showNumberFormatError();
            return askUserForBalance();
        } catch (NegativeAmountException e) {
            ui.showNegativeAmountError();
            return askUserForBalance();
        }
    }
    //@@author Sherlock-YH
    /**
     * Creates a new account and adds it to the AccountList.
     *
     * @param name    Name of the new account to be added
     * @param balance Balance of the new account to be added
     */
    public void addAccount(String name, String balance) {
        Account newAccount = new Account(name, balance);
        accounts.add(newAccount);
        ui.showNewAccountAdded(newAccount);
    }
    //@@author
    /**
     * Creates a new Account for a first time user
     */
    public void createNewAccount() {
        String userName = askUserForName();
        String balance = askUserForBalance();
        addAccount(userName, balance);
    }
    //@@author Sherlock-YH
    /**
     * Name and balance are separated by ; prepared to be saved
     *
     * @return returns all accounts details in String format
     */
    public String getAllAccountDetails() throws AccountNotFoundException {
        if (accounts.isEmpty()) {
            throw new AccountNotFoundException();
        } else {
            StringBuilder temp = new StringBuilder();
            for (Account acc : accounts) {
                temp.append(acc.getAccountName()).append(";").append(acc.getAccountBalance());
                temp.append("\n");
            }
            return temp.toString();
        }
    }
    //@@author
    public void showBal() {
        String balance = getMainAccount().getAccountBalance();
        ui.showBal(balance);
    }

    public void depositMoney(String depositAmountString) throws NumberFormatException,
            NullPointerException, NegativeAmountException {
        float depositAmount = Float.parseFloat(depositAmountString);
        if (depositAmount < 0) {
            throw new NegativeAmountException();
        } else {
            getMainAccount().addBalance(depositAmount);
        }
    }

    public void withdrawMoney(String withdrawAmountString) throws NumberFormatException,
            NegativeAmountException, InsufficientBalanceException {
        float withdrawAmount = Float.parseFloat(withdrawAmountString);
        if (withdrawAmount < 0) {
            throw new NegativeAmountException();
        }
        float currentBalance = Float.parseFloat(getMainAccount().getAccountBalance());
        if (currentBalance < withdrawAmount) {
            throw new InsufficientBalanceException();
        } else {
            getMainAccount().subtractBalance(currentBalance,withdrawAmount);
        }
    }

    //@@author Sherlock-YH
    public void deleteAccount(String name) {
        for (Account acc : accounts) {
            if (acc.getAccountName().contains(name)) {
                accounts.remove(acc);
                ui.showAccountDeleted(name);
                return;
            }
        }
        ui.showNoAccountFound();
    }

    //@@author Sherlock-YH
    public int getSize() {
        return accounts.size();
    }

    //@@author Sherlock-YH
    public void switchMainAccount(String accName) throws NoAccountException {
        //swap acc to the head of AccountList
        if (accounts.size() == 0) {
            throw new NoAccountException();
        } else if (accounts.size() == 1) {
            ui.showThereIsOnlyOneAccount();
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getAccountName().contains(accName)) {
                    Collections.swap(accounts, i, 0);
                    ui.showMainAccountSwitched();
                    ui.showCurrentAccount(accounts.get(0));
                    return;
                }
            }
            ui.showNoAccountFound();
        }

    }
}
