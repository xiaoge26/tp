package seedu.bankwithus;

public class Account {
    protected String name;
    protected float balance;


    /**
     * @param name initialise in the name of the account
     * @param balance initialise the balance of the account
     */
    public Account(String name, float balance){
        this.name = name;
        this.balance = balance;
    }

    /**
     * @return returns a string contains the name of the Account
     */
    public String getAccountName(){
        return name;
    }

    public float getAccountBalance(){
        return balance;
    }

}
