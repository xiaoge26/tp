package seedu.bankwithus;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BankWithUs {

    public static final String FILE_PATH = "data/save.txt";

    private Storage storage;
    private Ui ui;
    private AccountList accounts;

    public BankWithUs(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            accounts = new AccountList(storage.load());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            try {
                storage.createNewFile();
            } catch (IOException ioE) {
                ui.showIOError();
                throw ioE;
            }
            accounts = new AccountList();
        }
    }

    public void run() {

    }
    public static void main(String[] args) {
        try {
            new BankWithUs(FILE_PATH).run();
        } catch (IOException e) {
            return;
        }
    }
}
