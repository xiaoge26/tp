package seedu.bankwithus;

import seedu.bankwithus.exceptions.CommandNotFoundException;
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
        String[] split = input.trim().split("\\s+", 2);
        String command = split[0];
        String args = split.length == 2 ? split[1] : "";

        if (command.equals("exit")) {
            bwu.isExitEntered = true;
        } else {
            throw new CommandNotFoundException();
        }
    }
}
