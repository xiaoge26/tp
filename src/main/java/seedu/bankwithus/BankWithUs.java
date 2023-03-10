package seedu.bankwithus;

public class BankWithUs {

    public static final String FILE_PATH = "data/save.txt";

    private Storage storage;
    private Ui ui;
    private AccountList accounts;

    public BankWithUs(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
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
