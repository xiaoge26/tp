//@@author tyuyang
package seedu.bankwithus.storage;

import org.junit.jupiter.api.Test;
import seedu.bankwithus.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StorageTest {
    @Test
    public void load_normalSaveFile_noMessage() {
        assertDoesNotThrow(() -> new Storage("data/save.txt", "data/transaction.txt"));
    }
}
