package seedu.bankwithus.storage;

import seedu.bankwithus.data.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionDecoder {
    private static final String PATTERN_STRING = "(\\w+) t/(\\w+) a/(\\w+) d/(\\w+)";

    private static final Pattern PATTERN = Pattern.compile(PATTERN_STRING);

    public static Transaction decodeTransaction(String encodedTransaction) {
        Matcher matcher = PATTERN.matcher(encodedTransaction);
        if (matcher.matches()) {
            String accountName = matcher.group(1);
            String type = matcher.group(2);
            String amount = matcher.group(3);
            LocalDate date = LocalDate.parse(matcher.group(4), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return new Transaction(accountName, type, amount, date);
        } else {
            throw new IllegalArgumentException("Invalid transaction format: " + encodedTransaction);
        }
    }
}
