package seedu.bankwithus;

import org.junit.jupiter.api.Test;
import seedu.bankwithus.data.AccountList;
import seedu.bankwithus.exceptions.NegativeAmountException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountListTest {
    @Test
    void depositMoney_notANumber_expectException() {
        String amountString = "abc";
        String name = "Bob";
        String balance = "0";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(NumberFormatException.class,
                () -> accountList.depositMoney(amountString));
    }

    @Test
    void depositMoney_negativeNumber_expectException() {
        String amountString = "-1000";
        String name = "Bob";
        String balance = "100";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(NegativeAmountException.class,
                () -> accountList.depositMoney(amountString));
    }
    //This test tests the depositMoney method in AccountList.java when a large amount is deposited.
    // The expected result is that the correct amount is deposited.
    // Uncomment this test when the bug is fixed.
    //    @Test
    //    void depositMoney_largeAmount_expectDeposit() {
    //        String amountString = "12345678.85";
    //        String name = "Bob";
    //        String balance = "100.05";
    //        AccountList accountList = new AccountList();
    //        Ui ui = new Ui();
    //        accountList.addAccount(name, balance);
    //        try {
    //            accountList.depositMoney(amountString);
    //        } catch (NumberFormatException e) {
    //            ui.showNumberFormatError();
    //        } catch (NullPointerException e) {
    //            ui.showNullInputError();
    //        } catch (NegativeAmountException e) {
    //            ui.showNegativeAmountError();
    //        }
    //        assertEquals("12345778.9", accountList.getMainAccount().getAccountBalance());
    //    }

    //@@author xiaoge26
    @Test
    void testingAddAccount_validInput_expectNewAccount() {
        AccountList testAccountList = new AccountList();
        testAccountList.addAccount("Jane", "1000", "");
        assertEquals("Jane", testAccountList.getMainAccount().getName());
        assertEquals("1000", testAccountList.getMainAccount().getAccountBalance());
    }

    //@@author tyuyang
    @Test
    void setWithdrawalLimit_validInput_noException() {
        AccountList testAccountList = new AccountList();
        //No initial withdrawal limit
        testAccountList.addAccount("Hihi", "1000", "");
        assertDoesNotThrow(() -> testAccountList.setWithdrawalLimit("1.11"));
        assertEquals("1.11", testAccountList.getMainAccount()
                .getWithdrawalChecker().getWithdrawalLimit());
        
        //With initial withdrawal limit
        assertDoesNotThrow(() -> testAccountList.setWithdrawalLimit("2.23"));
        assertEquals("2.23", testAccountList.getMainAccount()
                .getWithdrawalChecker().getWithdrawalLimit());
    }

    //@@author tyuyang
    @Test
    void setWithdrawalLimit_negativeInput_negativeAmountExceptionThrown() {
        AccountList testAccountList = new AccountList();
        //No initial withdrawal limit
        testAccountList.addAccount("Hihi", "1000", "");
        assertThrows(NegativeAmountException.class, 
                () -> testAccountList.setWithdrawalLimit("-100"));
        assertEquals(null, testAccountList.getMainAccount()
                .getWithdrawalChecker().getWithdrawalLimit());

        //With initial withdrawal limit
        assertDoesNotThrow(() -> testAccountList.setWithdrawalLimit("1000"));
        assertThrows(NegativeAmountException.class, 
                () -> testAccountList.setWithdrawalLimit("-1.10"));
        assertEquals("1000", testAccountList.getMainAccount()
                .getWithdrawalChecker().getWithdrawalLimit());
    }

    //@@author tyuyang
    @Test
    void setWithdrawalLimit_nonNumberInput_numberFormatExceptionThrown() {
        AccountList testAccountList = new AccountList();
        //No initial withdrawal limit
        testAccountList.addAccount("Byebye", "10010", "");
        assertThrows(NumberFormatException.class, 
                () -> testAccountList.setWithdrawalLimit("ab"));
        assertEquals(null, testAccountList.getMainAccount()
                .getWithdrawalChecker().getWithdrawalLimit());

        //With initial withdrawal limit
        assertDoesNotThrow(() -> testAccountList.setWithdrawalLimit("11000"));
        assertThrows(NumberFormatException.class, 
                () -> testAccountList.setWithdrawalLimit(""));
        assertEquals("11000", testAccountList.getMainAccount()
                .getWithdrawalChecker().getWithdrawalLimit());
    }
}
