package seedu.bankwithus.storage;

import seedu.bankwithus.data.Transaction;
import seedu.bankwithus.data.TransactionList;

class TransactionEncoder {
    public static String encodeTransaction(Transaction transaction) {
        final StringBuilder encodedTransactionBuilder = new StringBuilder();

        encodedTransactionBuilder.append(transaction.getAccountName());
        encodedTransactionBuilder.append(" t/").append(transaction.getType());
        encodedTransactionBuilder.append(" a/").append(transaction.getAmount());
        encodedTransactionBuilder.append(" d/").append(transaction.getDateStr());

        return encodedTransactionBuilder.toString();
    }

    public static String encodeTransactionList(TransactionList transactionList) {
        if (transactionList.getSize() == 0) {
            return "";
        } else {
            final StringBuilder encodedTransactionListBuilder = new StringBuilder();
            for (Transaction transaction : transactionList.getTransactions()) {
                encodedTransactionListBuilder.append(encodeTransaction(transaction));
                encodedTransactionListBuilder.append(System.lineSeparator());
            }
            return encodedTransactionListBuilder.toString();
        }
    }
}
