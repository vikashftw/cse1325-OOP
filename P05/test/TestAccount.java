package test;

import customer.Account;
import customer.Unlimited;

public class TestAccount {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Unlimited();
            if (accounts[i].getAccountNumber() != i + 1) {
                System.out.println("FAIL: Account " + (i + 1) + " number is incorrect.");
                System.exit(1);
            }
        }

        System.exit(0);
    }
}
