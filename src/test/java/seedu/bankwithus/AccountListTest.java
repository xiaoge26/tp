package seedu.bankwithus;

import org.junit.jupiter.api.Test;
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
}
