package seedu.bankwithus;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SaveGoal {
    public float amtToSave;
    public LocalDate untilWhen;

    public SaveGoal(float amtToSave, String untilWhenStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            this.untilWhen = LocalDate.parse(untilWhenStr, formatter);
            this.amtToSave = amtToSave;
            Ui.showSaveGoalCreated(Float.toString(amtToSave), untilWhenStr);
        } catch (DateTimeException e) {
            System.out.println("Incorrect Date format, Try again following dd-MM-YYYY format!");
        }
    }


}
