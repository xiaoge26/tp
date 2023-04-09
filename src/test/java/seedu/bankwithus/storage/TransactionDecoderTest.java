package seedu.bankwithus.storage;

import org.junit.jupiter.api.Test;
import seedu.bankwithus.user.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionDecoderTest {
    @Test
    void testDecodeTransaction_validInput() {
        TransactionDecoder transactionDecoder = new TransactionDecoder();
        String encodedTransaction = "MyAccount;withdraw;1000.00;23/08/2021";
        Transaction expectedTransaction = new Transaction("MyAccount", "withdraw", "1000.00", LocalDate.parse("23/08/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Transaction result = transactionDecoder.decodeTransaction(encodedTransaction);

        assertEquals(expectedTransaction.getAccountName(), result.getAccountName());
        assertEquals(expectedTransaction.getType(), result.getType());
        assertEquals(expectedTransaction.getAmount(), result.getAmount());
        assertEquals(expectedTransaction.getDate(), result.getDate());
    }

    @Test
    void testDecodeTransaction_invalidInput_missingField() {
        TransactionDecoder transactionDecoder = new TransactionDecoder();
        String encodedTransaction = "MyAccount;withdraw;1000.00";

        assertThrows(IllegalArgumentException.class, () -> transactionDecoder.decodeTransaction(encodedTransaction));
    }

    @Test
    void testDecodeTransaction_invalidInput_wrongDateFormat() {
        TransactionDecoder transactionDecoder = new TransactionDecoder();
        String encodedTransaction = "MyAccount;credit;1000.00;23-08-2021";

        assertThrows(DateTimeParseException.class, () -> transactionDecoder.decodeTransaction(encodedTransaction));
    }

    @Test
    void testDecodeTransaction_invalidInput_extraField() {
        TransactionDecoder transactionDecoder = new TransactionDecoder();
        String encodedTransaction = "MyAccount;deposit;1000.00;23/08/2021;extraField";

        assertThrows(IllegalArgumentException.class, () -> transactionDecoder.decodeTransaction(encodedTransaction));
    }

}