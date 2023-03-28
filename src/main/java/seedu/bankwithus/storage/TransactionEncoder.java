package seedu.bankwithus.storage;

import seedu.bankwithus.user.Transaction;
import seedu.bankwithus.user.TransactionList;

class TransactionEncoder {
    public String encodeTransaction(Transaction transaction) {

        //minor fix in the code, buggy
        final StringBuilder encodedTransactionBuilder;
        encodedTransactionBuilder = new StringBuilder();

        encodedTransactionBuilder.append(transaction.getAccountName());
        encodedTransactionBuilder.append(";").append(transaction.getType());
        encodedTransactionBuilder.append(";").append(transaction.getAmount());
        encodedTransactionBuilder.append(";").append(transaction.getDateStr());

        return encodedTransactionBuilder.toString();
    }

    public String encodeTransactionList(TransactionList transactionList) {
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
