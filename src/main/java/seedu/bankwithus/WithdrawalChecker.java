package seedu.bankwithus;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class WithdrawalChecker {
    private String totalAmtWithdrawn;
    private LocalDate lastWithdrawnDate;

    /**
     * Instantiates withdrawalChecker without any amount withdrawn
     */
    public WithdrawalChecker() {
        this.totalAmtWithdrawn = "0";
    }

    /**
     * Instantiates withdrawalChecker with amount withdrawn and 
     * last known withdrawal date
     * @param totalAmtWithdrawn amount withdrawn
     * @param lastWithdrawnDate last known withdrawal date
     */
    public WithdrawalChecker(String totalAmtWithdrawn, LocalDate lastWithdrawnDate) {
        this.totalAmtWithdrawn = totalAmtWithdrawn;
        this.lastWithdrawnDate = lastWithdrawnDate;
    }

    public String getTotalAmtWithdrawn() {
        return this.totalAmtWithdrawn;
    }

    //@@author tyuyang
    /**
     * Updates the totalAmtWithdrawn attribute. In general, if the current month is
     * the same as the last withdrawn month, then add to the total amount withdrawn,
     * if not, then reset the total amount withdrawn.
     * 
     * @param withdrawal the amount that was just withdrawn
     */
    public void updateTotalAmtWithdrawn(float withdrawal) {
        LocalDate currentDate = LocalDate.now();
        DecimalFormat df = new DecimalFormat("#.##");
        if (lastWithdrawnDate == null) {
            lastWithdrawnDate = currentDate;
            String formatted = df.format(withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
            return;
        }
        assert totalAmtWithdrawn != null;
        if (lastWithdrawnDate.getMonth() == currentDate.getMonth() && 
                lastWithdrawnDate.getYear() == currentDate.getYear()) {
            String formatted = df.format(Float.parseFloat(totalAmtWithdrawn) + withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
        } else {
            String formatted = df.format(withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
        }
        lastWithdrawnDate = currentDate;
    }

    @Override
    public String toString() {
        if (lastWithdrawnDate == null) {
            return totalAmtWithdrawn + ";";
        } else {
            return totalAmtWithdrawn + ";" + lastWithdrawnDate.toString();
        }
    }
}
