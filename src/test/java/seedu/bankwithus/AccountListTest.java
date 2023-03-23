package seedu.bankwithus;

 import org.junit.jupiter.api.Test;
 import seedu.bankwithus.exceptions.CorruptedSaveFileException;
 import seedu.bankwithus.exceptions.NegativeAmountException;

 import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountListTest {
    Ui ui = new Ui();
     @Test
     void addAccount_invalidBalance_expectException() throws NumberFormatException {
         String name = "Bob";
         String balanceString = "abc";
         AccountList accountList = new AccountList();
         assertThrows(NumberFormatException.class,
                 () -> accountList.addAccount(name, balanceString));
     }

     @Test
     void depositMoney_invalidAmount_expectException() throws NumberFormatException {
         String amountString = "abc";
         String name = "Bob";
         String balance = "0";
         AccountList accountList = new AccountList();
         try {
             accountList.addAccount(name, balance);
         } catch (NumberFormatException e) {
             ui.showNumberFormatError();
         } catch (NullPointerException e) {
             ui.showNullInputError();
         } catch (NegativeAmountException e) {
             ui.showNegativeAmountError();
         }
         assertThrows(NumberFormatException.class,
                 () -> accountList.depositMoney(amountString));
     }

     @Test
     void depositMoney_validAmount_expectDeposit() {
         String amountString = "100.5";
         String name = "Bob";
         String balance = "100.5";
         AccountList accountList = new AccountList();
         Ui ui = new Ui();
         try {
             accountList.addAccount(name, balance);
             accountList.depositMoney(amountString);
         } catch (NumberFormatException e) {
             ui.showNumberFormatError();
         } catch (NullPointerException e) {
             ui.showNullInputError();
         } catch (NegativeAmountException e) {
             ui.showNegativeAmountError();
         }
         assertEquals("201", accountList.getMainAccount().getAccountBalance());
     }

     /**
     @Test
     void testingAddAccount() {
         AccountList TestAccountList = new AccountList();
         TestAccountList.addAccount("Jane", "1000");
         assertEquals("Jane", TestAccountList.getMainAccount().getName());
         assertEquals("1000", TestAccountList.getMainAccount().getAccountBalance());
     }
     **/
}
