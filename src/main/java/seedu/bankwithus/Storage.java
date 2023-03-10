package seedu.bankwithus;

import java.util.Scanner;

public class Storage {

    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }
    
    public Scanner load() {
        Scanner s = new Scanner(filepath);
        return s;
    }

}
