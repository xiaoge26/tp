package seedu.bankwithus.storage;

import seedu.bankwithus.data.AccountList;
import seedu.bankwithus.data.Transaction;
import seedu.bankwithus.data.TransactionList;
import seedu.bankwithus.exceptions.TransactionNotFoundException;
import seedu.bankwithus.ui.Ui;
import seedu.bankwithus.exceptions.AccountNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    protected File accountFile;
    protected File TransactionFile;
    private final File saveDir = new File("data");

    private Ui ui;
    private static final String DELIMITER = "|";

    /**
     * Creates a new instance of Storage. Initialises ui and saveFile.
     *
     * @param filepath the filepath. Should be data/save.txt by default
     */
    public Storage(String filepath) {
        this.accountFile = new File(filepath);
        this.TransactionFile = new File("data/transaction.txt");
        this.ui = new Ui();
    }

    /**
     * Loads the saveFile contexts into AccountList.
     *
     * @return the scanner containing the contents of the saveFile
     * @throws FileNotFoundException if file is not found
     */
    public Scanner load() throws FileNotFoundException {
        return new Scanner(accountFile);
    }

    /**
     * Creates a new saveFile if file is not found. Also creates the data directory
     *
     * @throws IOException if something goes really wrong. Should almost never happen
     */
    public void createNewFile() throws IOException {
        saveDir.mkdir();
        accountFile.createNewFile();
        ui.showFileCreated();
    }

    //@@author Sherlock-YH
    /**
     * This method saves all account details to data/save.txt
     *
     * @param list The AccountList that stores all accounts
     */
    public void saveToFile(AccountList list) throws IOException {
        FileWriter fw = new FileWriter(accountFile);
        try {
            fw.write(list.getAllAccountDetails());
            fw.close();
        } catch (AccountNotFoundException e) {
            fw.close();
        }
    }

    //@@author xiaoge26
    /**
     * This method saves all transaction details to data/save.txt
     *
     * @param transactionList The TransactionList that stores all transactions
     */
    public void saveTransactionsToFile(TransactionList transactionList) throws IOException {
        FileWriter fw = new FileWriter(accountFile);
        fw.write(TransactionEncoder.encodeTransactionList(transactionList));
        fw.close();
    }
}
