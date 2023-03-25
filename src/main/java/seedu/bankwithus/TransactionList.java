package seedu.bankwithus;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionList {
    private ArrayList<Transaction> transactions;
    private int size;

    public TransactionList() {
        this.transactions = new ArrayList<>();
        this.size = 0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        size++;
    }

    public Transaction getTransaction(int index) {
        return transactions.get(index);
    }
    public int getSize() {
        return size;
    }

    public void clearTransactionList() {
        transactions.clear();
        size = 0;
    }

    public void printAllTransactions() {
        for (int i = 0; i < size; i++) {
            System.out.println(transactions.get(i).toString());
        }
    }

    public void printTransactionListByType(String type) {
        for (int i = 0; i < size; i++) {
            if (transactions.get(i).getType().equals(type))
            System.out.println(transactions.get(i).toString());
        }
    }
    public void printTransactionListByDate(LocalDate date) {
        for (int i = 0; i < size; i++) {
            if (transactions.get(i).getDate().isBefore(date))
            System.out.println(transactions.get(i).toString());
        }
    }
}
