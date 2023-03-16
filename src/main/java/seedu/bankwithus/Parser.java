package seedu.bankwithus;

import seedu.bankwithus.exceptions.CommandNotFoundException;
import seedu.bankwithus.exceptions.CorruptedSaveFileException;
import seedu.bankwithus.exceptions.NegativeAmountException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private BankWithUs bwu;
    private AccountList accountList;

    public Parser(BankWithUs bwu) {
        this.bwu = bwu;
    }

    public Parser(AccountList accountList) {
        this.accountList = accountList;
    }

    public float parseWithdrawAmt(String args) throws NegativeAmountException {
        float withdrawAmt = Float.parseFloat(args);
        if (withdrawAmt < 0) {
            throw new NegativeAmountException();
        }
        float currBal = bwu.getAccountList().getCurrentAccount().balance;
        float finalBal = currBal-withdrawAmt;
        return finalBal;
    }

    /**
     * Parses the user input into command and arguments.
     */
    public void parseUserInput(String input) throws CommandNotFoundException {
        // Split input by space
        String[] split = input.trim().split("\\s+", 2);
        String command = split[0];
        String args = split.length == 2 ? split[1] : "";
        Ui screen = new Ui();
        switch (command) {
        case "exit":
            bwu.isExitEntered = true;
            break;
        case "deposit":
            try {
                bwu.getAccountList().depositMoney(args);
                screen.showDepositMessage();
                screen.showBal(bwu.getAccountList().getCurrentAccount().getAccountBalance());
            } catch (NumberFormatException e) {
                screen.showNumberFormatError();
            } catch (NullPointerException e) {
                screen.showNullInputError();
            } catch (NegativeAmountException e) {
                screen.showNegativeAmountError();
            }
            break;
        case "view-account":
            String accDetails = bwu.getAccountList().getAllAccountDetails();
            screen.viewAccount(accDetails);
            break;
        case "withdraw":
            try {
                float finalBal = parseWithdrawAmt(args);
                if(finalBal >= 0) {
                    bwu.getAccountList().getCurrentAccount().setBalance(finalBal);
                    screen.showBal(finalBal);
                } else {
                    screen.showInsufficientBalanceMessage();
                }
            } catch (NumberFormatException e) {
                screen.showNumberFormatError();
            } catch (NegativeAmountException e) {
                screen.showNegativeAmountError();
            }
            break;
        case "help":
            screen.showHelp();
            break;
        default:
            throw new CommandNotFoundException();
        }
    }



    // /**
    //  * This method reads any existing file and add the saved data
    //  * into current programme
    //  *
    //  * @param list current operation AccountList
    //  */
    // public void parseSavedFile(AccountList list) throws IOException {
    //     File f = new File("data/save.txt");
    //     Scanner myReader = new Scanner(f);
    //     while (myReader.hasNextLine()) {
    //         String data = myReader.nextLine();
    //         String[] splitDetails = data.split(";");
    //         String name = splitDetails[0];
    //         String balanceString = splitDetails[1];
    //         list.addAccount(name, balanceString);
    //     }
    //     myReader.close();
    // }

    public void parseSavedFile(Scanner scanner) throws CorruptedSaveFileException {
        String accountDetails = scanner.nextLine();
        accountDetails.trim();
        if (accountDetails.isBlank()) {
            throw new CorruptedSaveFileException();
        }
        String[] splitDetails = accountDetails.split(";");
        String name = splitDetails[0];
        String balanceString = splitDetails[1];
        try {
            float balance = Float.parseFloat(balanceString);
            accountList.addAccount(name, balance);
        } catch (Exception e) {
            throw new CorruptedSaveFileException();
        }
    }
}
