package seedu.bankwithus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    private final File SAVE_DIR = new File("data");
    private File saveFile;
    private Ui ui;

    /**
     * Creates a new instance of Storage. Initialises ui and saveFile.
     *
     * @param filepath the filepath. Should be data/save.txt by default
     */
    public Storage(String filepath) {
        this.saveFile = new File(filepath);
        this.ui = new Ui();
    }

    /**
     * Loads the saveFile contexts into AccountList.
     *
     * @return the scanner containing the contents of the saveFile
     *
     * @throws FileNotFoundException if file is not found
     */
    public Scanner load() throws FileNotFoundException {
        return new Scanner(saveFile);
    }

    /**
     * Creates a new saveFile if file is not found. Also creates the data directory
     *
     * @throws IOException if something goes really wrong. Should almost never happen
     */
    public void createNewFile() throws IOException {
        SAVE_DIR.mkdir();
        saveFile.createNewFile();
        ui.showFileCreated();
    }

}
