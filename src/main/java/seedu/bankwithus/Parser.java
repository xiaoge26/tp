package seedu.bankwithus;

import seedu.bankwithus.exceptions.CommandNotFoundException;
import seedu.bankwithus.BankWithUs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    private BankWithUs bwu;

    public Parser(BankWithUs bwu) {
        this.bwu = bwu;
    }

    /**
     * Parses the user input into command and arguments.
     */
    
    public void parseUserInput(String input) throws CommandNotFoundException {
        // Split input by space
        String[] split = input.trim().split(" ", 2);
        String command = split[0];
        String args = split.length == 2 ? split[1] : "";

        switch (command) {
        case "exit": {
            bwu.isExitEntered = true;
            break;
        }

        case "balance" : {
            for(Account acc : AccountList.accounts) {
                System.out.println(acc.balance);
            }
            break;
        }
        default:
            throw new CommandNotFoundException();
        }
    }


}
