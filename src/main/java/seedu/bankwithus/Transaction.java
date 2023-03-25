package seedu.bankwithus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String AccountName;
    private String amount;

    //Take Note of this date is in LocalDate format, but not a String!
    private LocalDate date;
    private String type;

    public Transaction(String AccountName, String amount, LocalDate date, String type) {
        this.AccountName = AccountName;
        this.amount = amount;
        this.date = LocalDate.now();
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account Name: " + AccountName
                + " Transaction Type: " + type
                + " Amount: " + amount
                + " Date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public String getAccountName() {
        return AccountName;
    }

    public String getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
