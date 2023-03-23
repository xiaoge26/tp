package seedu.bankwithus;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class WithdrawalCheckerTest {
    @Test
    public void updateTotalAmtWithdrawn_validInput_noException() {
        WithdrawalChecker wcNoWithdrawals = new WithdrawalChecker();
        //test without withdrawals
        assertDoesNotThrow(() -> wcNoWithdrawals.updateTotalAmtWithdrawn((float) 10.1));
        assertEquals("10.1", wcNoWithdrawals.getTotalAmtWithdrawn());

        //test with prior withdrawals
        assertDoesNotThrow(() -> wcNoWithdrawals.updateTotalAmtWithdrawn((float) 1.1));
        assertEquals("11.2", wcNoWithdrawals.getTotalAmtWithdrawn());

        WithdrawalChecker wcWithWithdrawals = new WithdrawalChecker("10.01", 
                LocalDate.parse("2023-01-10"));
        
        //test with prior withdrawals in a different month
        assertDoesNotThrow(() -> wcWithWithdrawals.updateTotalAmtWithdrawn((float) 1.11));
        assertEquals("1.11", wcWithWithdrawals.getTotalAmtWithdrawn());
    }
}
