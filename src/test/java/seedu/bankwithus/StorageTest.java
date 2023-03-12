package seedu.bankwithus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StorageTest {
    @Test
    public void load_normalSaveFile_noMessage() {
        assertDoesNotThrow(() -> new Storage("data/save.txt"));
        Storage storage = new Storage("data/save.txt");
        assertDoesNotThrow(() -> storage.load());
    }
}
