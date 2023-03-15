package seedu.bankwithus;

import seedu.bankwithus.exceptions.CommandNotFoundException;
import seedu.bankwithus.exceptions.NegativeAmountException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private BankWithUs bwu;

    public Parser(BankWithUs bwu) {
        this.bwu = bwu;
    }

    public float parseWithdrawAmt(String args) throws NegativeAmountException {
        float withdrawAmt = Float.parseFloat(args);
        if (withdrawAmt < 0) {
            throw new NegativeAmountException();
        }
        float currBal = bwu.accounts.accounts.get(0).balance;
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
        case "view-account":
            String accDetails = bwu.accounts.getAllAccountDetails();
            screen.viewAccount(accDetails);
            break;
        case "withdraw":
            try {
                float finalBal = parseWithdrawAmt(args);
                if(finalBal >= 0) {
                    bwu.accounts.accounts.get(0).setBalance(finalBal);
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
        default:
            throw new CommandNotFoundException();
        }

    }



    /**
     * This method reads any existing file and add the saved data
     * into current programme
     *
     * @param list current operation AccountList
     */
    public void parseSavedFile(AccountList list) throws IOException {
        File f = new File("data/save.txt");
        Scanner myReader = new Scanner(f);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splitDetails = data.split(";");
            String name = splitDetails[0];
            String balance = splitDetails[1];
            list.addAccount(name, balance);
        }
        myReader.close();
    }
}
