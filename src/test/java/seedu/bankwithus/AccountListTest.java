package seedu.bankwithus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountListTest {

    @Test
    void addAccount_invalidBalance_expectException() throws NullPointerException {
        String name = "Bob";
        String balanceString = "abc";
        AccountList accountList = new AccountList();
        assertThrows(NullPointerException.class,
                () -> accountList.addAccount(name, balanceString));
    }

    @Test
    void depositMoney_invalidAmount_expectException() throws NullPointerException {
        String amountString = "abc";
        String name = "Bob";
        String balance = "0";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance);
        assertThrows(NullPointerException.class,
                () -> accountList.depositMoney(amountString));
    }

    @Test
    void depositMoney_validAmount_expectDeposit() {
        String amountString = "100.5";
        String name = "Bob";
        String balance = "100.5";
        AccountList accountList = new AccountList();
        accountList.addAccount(name, balance);
        accountList.depositMoney(amountString);
        assertEquals(201, accountList.getCurrentAccount().getAccountBalance());
    }
}
