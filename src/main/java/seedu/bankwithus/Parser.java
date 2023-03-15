package seedu.bankwithus;

import seedu.bankwithus.exceptions.CommandNotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private BankWithUs bwu;

    public Parser(BankWithUs bwu) {
        this.bwu = bwu;
    }

    public float parseWithdrawAmt(String args) {
        float withdrawAmt = Float.parseFloat(args);
        float currBal = bwu.accounts.accounts.get(0).balance;
        float final_bal = currBal-withdrawAmt;
        return final_bal;
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
                float final_bal = parseWithdrawAmt(args);
                if(final_bal > -1) {
                    bwu.accounts.accounts.get(0).setBalance(final_bal);
                    screen.showBal(final_bal);
                } else {
                    System.out.println("You do not have sufficient Balance");
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
    }
}
