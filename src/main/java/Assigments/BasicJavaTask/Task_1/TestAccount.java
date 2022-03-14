package Assigments.BasicJavaTask.Task_1;
// TestAccounts1
// A simple program to test the numAccts method of the
// Account class.
//************************************************************
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TestAccount
{
    public static void main(String[] args)
    {
        //Scanner
        Account testAcct=null;
        List<Account> accountList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("How many accounts would you like to create?");
        int num = scan.nextInt();
        for (int i=1; i<=num; i++)
        {
            testAcct = new Account(0, "Name" + i);
            accountList.add(testAcct);
            System.out.println("\nCreated account " + testAcct);
            // Your code here: call method to print out how many accounts have been created so far
        }
        System.out.println("Total Number of accounts Created :"+testAcct.getTotalaccounts());

        //----delete accoutnt by name---
        System.out.println(testAcct.deleteAccount(accountList,"Name1"));
        System.out.println("Total Number of accounts Created :"+testAcct.getTotalaccounts());

//        System.out.println(accountList);
//        for(int i=0;i<accountList.size();i++){
//            System.out.println(accountList.get(i).getAcctNumber());
//        }
        //System.out.println(accountList.get(1).getAcctNumber());
    }
}
