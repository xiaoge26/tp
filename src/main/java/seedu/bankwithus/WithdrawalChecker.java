package seedu.bankwithus;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class WithdrawalChecker {
    private String totalAmtWithdrawn;
    private LocalDate lastWithdrawnDate;
    private String withdrawalLimit;
    private Logger logger = Logger.getLogger("Foo");

    /**
     * Instantiates withdrawalChecker without any amount withdrawn
     */
    public WithdrawalChecker() {
        logger.log(Level.INFO, "Default WithdrawalChecker contructor called");
        this.totalAmtWithdrawn = "0";
        logger.log(Level.INFO, "totalAmtWithdrawn set to " + totalAmtWithdrawn);
    }

    /**
     * Instantiates withdrawalChecker with amount withdrawn and 
     * last known withdrawal date
     * @param totalAmtWithdrawn amount withdrawn
     * @param lastWithdrawnDate last known withdrawal date
     */
    public WithdrawalChecker(String totalAmtWithdrawn, LocalDate lastWithdrawnDate) {
        logger.log(Level.INFO, "WithdrawalChecker contructer with set withdrawals called");
        this.totalAmtWithdrawn = totalAmtWithdrawn;
        this.lastWithdrawnDate = lastWithdrawnDate;
        logger.log(Level.INFO, "totalAntWithdrawn set to " + totalAmtWithdrawn);
        logger.log(Level.INFO, "lastWithdrawnDate set to " + lastWithdrawnDate.toString());
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
        logger.log(Level.INFO, "updateTotalAmtWithdrawn in WithdrawalChecker called");
        LocalDate currentDate = LocalDate.now();
        DecimalFormat df = new DecimalFormat("#.##");
        logger.log(Level.INFO, "Checking if account has withdrawal history");
        if (lastWithdrawnDate == null) {
            logger.log(Level.INFO, "No withdrawal history found, setting values now");
            lastWithdrawnDate = currentDate;
            String formatted = df.format(withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
            return;
        }
        assert totalAmtWithdrawn != null;
        if (lastWithdrawnDate.getMonth() == currentDate.getMonth() && 
                lastWithdrawnDate.getYear() == currentDate.getYear()) {
            logger.log(Level.INFO, "Previous withdrawal in the same month, adding to total");
            String formatted = df.format(Float.parseFloat(totalAmtWithdrawn) + withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
        } else {
            logger.log(Level.INFO, "Previous withdrawal in previous months, setting to new value");
            String formatted = df.format(withdrawal);
            totalAmtWithdrawn = String.valueOf(formatted);
        }
        lastWithdrawnDate = currentDate;
    }

    public void setWithdrawalLimit(float withdrawalLimit) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(withdrawalLimit);
        this.withdrawalLimit = String.valueOf(formatted);
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
