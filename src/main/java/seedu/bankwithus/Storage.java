package seedu.bankwithus;

import java.util.Scanner;

import static seedu.bankwithus.BankWithUs.FILE_PATH;

public class Storage {
    
    public Scanner load() {
        Scanner s = new Scanner(FILE_PATH);
        return s;
    }

}
