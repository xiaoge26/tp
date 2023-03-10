package seedu.bankwithus;

public class BankWithUs {

    private Storage storage;
    private Ui ui;
    private AccountList accounts;

    public static final String FILE_PATH = "data/save.txt";

    public BankWithUs(String filePath) {
        ui = new Ui();
        storage = new Storage();
        try {
            accounts = new AccountList(storage.load());
        } catch (Exception e) {
            ui.showLoadingError();
            accounts = new AccountList();
        }
    }

    public void run() {

    }
    public static void main(String[] args) {
        new BankWithUs(FILE_PATH).run();
    }
}
