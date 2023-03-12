package seedu.bankwithus;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankWithUsTest {
    @Test
    public void bankWithUs_emptyInput_exceptionThrown() {
        assertThrows(IOException.class, () -> new BankWithUs(""));
    }
}
