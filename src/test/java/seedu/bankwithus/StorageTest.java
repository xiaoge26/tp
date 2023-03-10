package seedu.bankwithus;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {
    @Test
    public void load_normalSaveFile_noMessage() {
        assertDoesNotThrow(() -> new Storage("data/save.txt"));
        Storage storage = new Storage("data/save.txt");
        assertDoesNotThrow(() -> storage.load());
    }
}
