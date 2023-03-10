package seedu.bankwithus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    private File saveFile;
    private final File SAVE_DIR = new File("data");
    private Ui ui;

    public Storage(String filepath) {
        this.saveFile = new File(filepath);
        this.ui = new Ui();
    }
    
    public Scanner load() throws FileNotFoundException {
        Scanner s = new Scanner(saveFile);
        return s;
    }

    public void createNewFile() throws IOException {
        SAVE_DIR.mkdir();
        saveFile.createNewFile();
        ui.showFileCreated();
    }

}
