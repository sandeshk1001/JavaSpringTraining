package Assigments.BasicJavaTask.Task_1;
// Account.java
//
// A bank account class with methods to deposit, withdraw,
// and check the balance.
//*******************************************************

import java.util.List;

public class Account
{
    private double balance;
    private String name;
    private long acctNum;
    public static int totalaccounts=0;


    //----------------------------------------------
    //Constructor -- initializes balance and owner; generates random
    //account number
    //----------------------------------------------
    public Account(double initBal, String owner)
    {
        balance = initBal;
        name = owner;
        acctNum = (int) (Math.random() * Integer.MAX_VALUE);
        totalaccounts++;
    }

    //----------------------------------------------
    //Constructor -- initializes owner as given and balance to 0.
    //Generates random account number
    //----------------------------------------------
    public Account(String owner)
    {
        balance = 0;
        name = owner;
        acctNum = (int) (Math.random() * Integer.MAX_VALUE);
        totalaccounts++;
    }

    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    //----------------------------------------------
    public void withdraw(double amount)
    {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    // Also deducts fee from account.
    //----------------------------------------------
    public void withdraw(double amount, double fee)
    {
        if (balance >= amount)
        {
            balance -= amount;
            balance -= fee;
        }
        else
            System.out.println("Insufficient funds");
    }

    //----------------------------------------------
    // Adds deposit amount to balance.
    //----------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
    }

    //public void close()

    //----------------------------------------------
    // Returns balance.
    //----------------------------------------------
    public double getBalance()
    {
        return balance;
    }

    //----------------------------------------------
    // Returns account number
    //----------------------------------------------
    public long getAcctNumber()
    {
        return acctNum;
    }
    public int getTotalaccounts() {
        return totalaccounts;
    }
    public String getName() {
        return name;
    }

    public List<Account> deleteAccount(List<Account> details, String name){
        for(int i=0;i<details.size();i++){
            if(name.compareTo(details.get(i).getName()) == 0){
                details.remove(i);
                totalaccounts--;
                return details;
            }
        }
        return  details;
    }

    public static Account consolidate(Account acc1,Account acc2,List<Account> details){
        if((acc1.getName().compareTo(acc2.getName()) ==0) && (acc1.getAcctNumber() != acc2.getAcctNumber()))
        {
            double balance = acc1.getBalance()+acc2.getBalance();

        }
        return null;
    }

    //----------------------------------------------
    // Returns a string containing the name, acct number, and balance.
    //----------------------------------------------
    public String toString()
    {
        return "Name: " + name +
                "\nAcct #: " + acctNum +
                "\nBalance: " + balance;
    }
}