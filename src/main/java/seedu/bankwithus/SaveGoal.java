package seedu.bankwithus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SaveGoal {
    public float amtToSave;
    public Date untilWhen;

    public SaveGoal(float amtToSave, String untilWhenStr) {
        this.amtToSave = amtToSave;

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.untilWhen = format.parse(untilWhenStr);
        } catch (ParseException e) {
            System.out.println("Please enter Date in DD-MM-YYYY format and retry");
            e.printStackTrace();
        }
    }
}
