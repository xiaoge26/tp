package seedu.bankwithus;

import seedu.bankwithus.exceptions.AccountNotFoundException;
import seedu.bankwithus.exceptions.CorruptedSaveFileException;
import seedu.bankwithus.exceptions.InsufficientBalanceException;
import seedu.bankwithus.exceptions.NegativeAmountException;
import seedu.bankwithus.exceptions.NoAccountException;
import seedu.bankwithus.exceptions.SaveFileIsEmptyException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

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
     * Instantiates AccountList for unit testing
     */
    public AccountList() {
        accounts = new ArrayList<Account>();
        this.ui = new Ui();
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
    public String askUserForName() {
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
    public String askUserForBalance() {
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

    //@@author xiaoge26
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

    //@@author vishnuvk47
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

    //@@author xiaoge26
    public void depositMoney(String depositAmountString) throws NumberFormatException,
            NullPointerException, NegativeAmountException {
        float depositAmount = Float.parseFloat(depositAmountString);
        if (depositAmount < 0) {
            throw new NegativeAmountException();
        } else {
            getMainAccount().addBalance(depositAmount);
        }
    }

    public LocalDate handleDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(formattedDate, format);
    }
    //@@author
    public void withdrawMoney(String withdrawAmountString) throws NumberFormatException,
            NegativeAmountException, InsufficientBalanceException {
        float withdrawAmount = Float.parseFloat(withdrawAmountString);
        if (withdrawAmount < 0) {
            throw new NegativeAmountException();
        }
        float currentBalance = Float.parseFloat(getMainAccount().getAccountBalance());
        float expectedBal = currentBalance - withdrawAmount;
        LocalDate tdy = LocalDate.now();
        LocalDate tdyDate = handleDate(tdy);
        if (currentBalance < withdrawAmount) {
            throw new InsufficientBalanceException();
        } else if(getMainAccount().getSaveGoal().amtToSave > expectedBal && !getMainAccount().getSaveGoal().untilWhen.isAfter(tdyDate)) {
            System.out.println("Withdrawing the specified amount would lead to failing to meet Save Goal");
            System.out.println("would you like to proceed? (Y/N)");
            handleProceed(withdrawAmount, currentBalance);
        } else {
            getMainAccount( ).subtractBalance(currentBalance,withdrawAmount);
            ui.showWithdrawMessage();
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
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void handleProceed(float withdrawAmount, float currentBalance) {
        String YesOrNo = ui.getNextLine();
        while(!(YesOrNo.equalsIgnoreCase("y") || YesOrNo.equalsIgnoreCase("n"))) {
            System.out.println("Please enter ONLY either Y for Yes and N for No.");
            YesOrNo = ui.getNextLine();
        }
        if(YesOrNo.equalsIgnoreCase("y")) {
            getMainAccount( ).subtractBalance(currentBalance,withdrawAmount);
            getMainAccount().setSaveGoal(new SaveGoal(0, "01-01-2001"));
            ui.showWithdrawMessage();

        } else {
            ui.showWithdrawCancelled();
        }
    }

    public void handleSaveGoal(String args, String untilWhenStr) {
        try {
            float toSave = Float.parseFloat(args);
            if (isDateFormatValid(untilWhenStr)) {
                SaveGoal saveGoal = new SaveGoal(toSave, untilWhenStr);
                getMainAccount().setSaveGoal(saveGoal);
            }
        } catch (NumberFormatException e) {
            ui.showNumberFormatError();
        }
    }
    public boolean isDateFormatValid(String date) {
        String regex = "\\d{2}-\\d{2}-\\d{4}";
        try {
            return date.matches(regex);
        } catch ( DateTimeException e) {
            System.out.println("Date is not in the correct format.");
            return false;
        }

    }

}
