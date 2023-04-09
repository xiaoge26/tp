package seedu.bankwithus.user;

import org.junit.jupiter.api.Test;
import seedu.bankwithus.exceptions.MoreThanTwoDecimalPlace;
import seedu.bankwithus.exceptions.NegativeAmountException;
import seedu.bankwithus.exceptions.NoAccountException;
import seedu.bankwithus.exceptions.ExceedsWithdrawalLimitException;
import seedu.bankwithus.exceptions.NoValueInputException;
import seedu.bankwithus.exceptions.InsufficientBalanceException;
import seedu.bankwithus.exceptions.WithdrawalCancelledException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountListTest {
    //@@author xiaoge26
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

    //@@author Sherlock-YH
    @Test
    void depositMoney_moreThanTwoDecimalPlaces_expectException() {
        String amountString = "1000.111";
        String name = "SHhhh";
        String balance = "1234";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(MoreThanTwoDecimalPlace.class,
                () -> accountList.depositMoney(amountString));

    }

    //@@author Sherlock-YH
    @Test
    void withdrawMoney_moreThanTwoDecimalPlaces_expectException() {
        String amountString = "0.111";
        String name = "SHhhh";
        String balance = "12333";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(MoreThanTwoDecimalPlace.class,
                () -> accountList.withdrawMoney(amountString));

    }

    //@@author vishnuvk47
    @Test
    void withdrawNegativeAmount() {
        AccountList accountList = new AccountList();
        accountList.addAccount("James", "1000", "");
        assertThrows(NegativeAmountException.class, () -> {
            accountList.withdrawMoney("-100");
        });
    }

    @Test
    void withdrawNegativeAmountWithDecimal() {
        AccountList accountList = new AccountList();
        accountList.addAccount("James", "1000", "");
        assertThrows(NegativeAmountException.class, () -> {
            accountList.withdrawMoney("-21.67");
        });
    }

    //@@author xiaoge26
    @Test
    void testingAddAccount_validInput_expectNewAccount() {
        AccountList testAccountList = new AccountList();
        testAccountList.addAccount("Jane", "1000", "");
        assertEquals("Jane", testAccountList.getMainAccount().getName());
        assertEquals(new BigDecimal("1000.00"), testAccountList.getMainAccount().getAccountBalance());
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

    //@@author vishnuvk47
    @Test
    public void testIsDateFormatValid() {
        AccountList acc = new AccountList();
        String validDate = "07-04-2023";
        String invalidDate = "2023-04-07";

        assertEquals(true, acc.isDateFormatValid(validDate));
        assertEquals(false, acc.isDateFormatValid(invalidDate));
    }

    @Test
    void depositMoney_nullAmount_expectException() {
        String amountString = null;
        String name = "SHhhh";
        String balance = "1234";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(NullPointerException.class,
                () -> accountList.depositMoney(amountString));
    }

    @Test
    void depositMoney_negativeAmount_expectException() {
        String amountString = "-1000.11";
        String name = "SHhhh";
        String balance = "1234";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(NegativeAmountException.class,
                () -> accountList.depositMoney(amountString));
    }

    @Test
    void depositMoney_validAmount_expectDeposit() throws NegativeAmountException, MoreThanTwoDecimalPlace {
        String amountString = "1000.11";
        String name = "SHhhh";
        String balance = "1234";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        BigDecimal expectedBalance = new BigDecimal(balance).add(new BigDecimal(amountString));
        accountList.depositMoney(amountString);
        assertEquals(expectedBalance, accountList.getMainAccount().getAccountBalance());
    }

    @Test
    void withdrawMoney_validAmount_expectWithdrawal() throws NegativeAmountException, NoValueInputException,
            WithdrawalCancelledException, InsufficientBalanceException, ExceedsWithdrawalLimitException,
            MoreThanTwoDecimalPlace {
        String amountString = "500.00";
        String name = "Test Account";
        String balance = "1000.00";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        BigDecimal expectedBalance = new BigDecimal(balance).subtract(new BigDecimal(amountString));
        accountList.withdrawMoney(amountString);
        assertEquals(expectedBalance, accountList.getMainAccount().getAccountBalance());
    }

    @Test
    void withdrawMoney_negativeAmount_expectException() {
        String amountString = "-1000.00";
        String name = "Test Account";
        String balance = "1234.56";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(NegativeAmountException.class,
                () -> accountList.withdrawMoney(amountString));
    }

    @Test
    void withdrawMoney_insufficientBalance_expectException() {
        String amountString = "5000.00";
        String name = "Test Account";
        String balance = "1234.56";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(InsufficientBalanceException.class,
                () -> accountList.withdrawMoney(amountString));
    }

    @Test
    void withdrawMoney_exceedWithdrawalLimit_expectException() {
        String amountString = "5000.00";
        String name = "Test Account";
        String balance = "12345.67";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "10");
        assertThrows(ExceedsWithdrawalLimitException.class,
                () -> accountList.withdrawMoney(amountString));
    }

    @Test
    void withdrawMoney_noValueInput_expectException() {
        String amountString = "    ";
        String name = "Test Account";
        String balance = "1234.56";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertThrows(NoValueInputException.class,
                () -> accountList.withdrawMoney(amountString));
    }

    //As per [PE-D][Tester A] [Bug] #144
    @Test
    void depositMoney_largestPossibleNumber_expectNoException() {
        String amountString = new BigDecimal(Double.MAX_VALUE).toString();
        String name = "Test Account";
        String balance = "0";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertDoesNotThrow(() -> accountList.depositMoney(amountString));
    }

    ////As per [PE-D][Tester A] [Bug] #144 --> extension from this bug
    @Test
    void depositMoney_onAccountLargeBalance_expectNoException() {
        String amountString = new BigDecimal(Double.MAX_VALUE).toString();
        String name = "Test Account";
        String balance = amountString;
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance, "");
        assertDoesNotThrow(() -> accountList.depositMoney(amountString));
    }

    //As per [PE-D][Tester A] [Bug] #144 --> also extension from this bug
    @Test
    void newAccount_largestPossibleNumber_expectNoException() {
        String balance = new BigDecimal(Double.MAX_VALUE).toString();
        String name = "Test Account";
        AccountList accountList = new AccountList();
        assertDoesNotThrow(() -> accountList.addAccount(name, balance, ""));
    }

    //[PE-D][Tester E] Accounts with similar name (or substring) ends up not being able to get switched over
    @Test
    void switchMainAccountSubstring_accountExists_expectSuccess() throws NoAccountException {
        AccountList accountList = new AccountList();
        accountList.addAccount("Account 1", "1000.00", "");
        accountList.addAccount("Account 2", "500.00", "");

        accountList.switchMainAccount("Account 2");

        assertEquals("Account 2", accountList.getMainAccount().getAccountName());
    }

    //Bug occurs where deleting an account will cause that name to be "blacklisted" #148
    @Test
    void deleteAccount_createNewAccountWithNameOfDeletedAccount_accountExpectSuccess() throws NoAccountException {
        AccountList accountList = new AccountList();
        accountList.addAccount("Account 1", "1000.00", "");
        accountList.addAccount("Account 2", "500.00", "");
        accountList.deleteAccount("Account 2");
        accountList.addAccount("Account 2", "500.00", "");
        accountList.switchMainAccount("Account 2");
        assertEquals("Account 2", accountList.getMainAccount().getAccountName());
    }
}
