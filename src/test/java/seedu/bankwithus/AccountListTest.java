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
    void testing_Add_New_account_Jane_with_1000_balance() {
        AccountList TestAccountList = new AccountList();
        TestAccountList.addAccount("Jane", "1000");
        assertEquals("Jane", TestAccountList.accounts.get(0).name);
        assertEquals(1000.0, TestAccountList.accounts.get(0).balance);
    }

}
