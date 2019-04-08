package bankaccountapp;

public abstract class Account implements IBaseRate{
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;


    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name =name;
        this.sSN = sSN;
        this.balance = initDeposit;
        //Set account number
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber =(int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * rate/100;
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        System.out.println("Your balance is now: $" + balance);
    }

    // List common methods - Transactions
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Transferring $" + amount);
        System.out.println("Your balance is now: $" + balance);
    }
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        System.out.println("Your balance is now: $" + balance);
    }
    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        System.out.println("Your balance is now: $" + balance);
    }


    public void showInfo() {
        System.out.println(
                "NAME: "+ name +
                "\nAccount NUMBER: "+ accountNumber +
                "\nBALANCE: " + balance +
                "\nRate: " + rate + "%"
        );
    }
}
