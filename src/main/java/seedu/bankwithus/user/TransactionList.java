package seedu.bankwithus.user;

import seedu.bankwithus.exceptions.CorruptedTransactionFileException;
import seedu.bankwithus.exceptions.NoTransactionsFoundException;
import seedu.bankwithus.exceptions.TransactionFileIsEmptyException;
import seedu.bankwithus.parser.Parser;
import seedu.bankwithus.ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionList {

    private ArrayList<Transaction> transactions;
    private int size;

    public TransactionList() {
        this.transactions = new ArrayList<>();
        this.size = 0;
    }

    /**
     * Creates a new instance of TransactionList. Initialises transactions.
     * Should load data into transactions list too.
     * @param scanner the scanner to be used to read the transaction file
     */
    public TransactionList(Scanner scanner) {
        this.size = 0;
        transactions = new ArrayList<>();
        Ui ui = new Ui();
        Parser parser = new Parser(this);
        try {
            parser.parseTransactionFile(scanner);
        } catch (CorruptedTransactionFileException e) {
            ui.showCorruptedTransactionFileError();
        } catch (TransactionFileIsEmptyException e) {
            //shows "No transactions found!" as this catch block
            ui.showNoTransactionsFoundMessage();
        }
    }


    /**
     * Creates a new transaction and adds it to the transaction list.
     *
     * @param accountName the name of the account
     * @param type the type of transaction
     * @param amount the amount of money involved in the transaction
     * @param date the date of the transaction
     */
    public void createNewTransaction(String accountName, String type, String amount, LocalDate date) {
        Transaction transaction = new Transaction(accountName, type, amount, date);
        assert transaction != null;
        transactions.add(transaction);
        size++;
    }

    /**
     * Adds a transaction to the transaction list.
     *
     * @param transaction the transaction to be added
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        size++;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public int getSize() {
        return size;
    }

    /**
     * Prints all transactions in the transaction list.
     *
     * @throws NoTransactionsFoundException thrown when there are no transactions in the transaction list
     */
    public void printAllTransactions() throws NoTransactionsFoundException {
        if (size == 0) {
            throw new NoTransactionsFoundException();
        }
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + ". " + transactions.get(i).toString());
        }
    }

    //@xiaoge26
    /**
     * Deletes a transaction from the transaction list.
     * @param args the index of the transaction to be deleted
     */
    public void deleteTransaction(String args) throws NoTransactionsFoundException,
            NumberFormatException, IndexOutOfBoundsException {
        Ui ui = new Ui();
        if (size == 0) {
            throw new NoTransactionsFoundException();
        }
        try {
            int index = Integer.parseInt(args) - 1;
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            transactions.remove(index);
            size--;
            ui.showTransactionDeletedMessage();
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes all transactions for a particular account.
     * @param accountName the name of the account
     */
    public void deleteTransactionsForAccount(String accountName) {
        for (int i = 0; i < size; i++) {
            if (transactions.get(i).getAccountName().equals(accountName)) {
                transactions.remove(i);
                size--;
                i--;
            }
        }
    }
}
