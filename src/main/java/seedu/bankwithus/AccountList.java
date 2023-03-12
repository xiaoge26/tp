package seedu.bankwithus;

import java.util.ArrayList;

public class AccountList {
    protected ArrayList<Account> accounts;

    public AccountList() {
    }

    /**
     * Creates a new account and adds it to the AccountList.
     *
     * @param name the name of the new account to be added
     * @param balanceString the balance of the new account to be added in String type
     */
    public void addAccount(String name, String balanceString) {
        float balance = Float.parseFloat(balanceString);
        Account newAccount = new Account(name, balance);
        accounts.add(newAccount);
    }
    
    public AccountList(String saveString) {

    }
}
