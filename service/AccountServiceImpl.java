package main.project.service;

import main.project.model.Account;
import main.project.model.Ewallet;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private  Ewallet ewallet = new Ewallet();

    @Override
    public boolean createAccount(Account account) {
        List<Account> accountList = ewallet.getAccounts();
        for (Account a : accountList) {
            if (a.getUserName().equals(account.getUserName())) {
                System.out.println("Account with username " + account.getUserName() + " already exists.");
                return false;
            }
        }
            accountList.add(account);
            System.out.println("Account created successfully for username: " + account.getUserName());
            return true; // Return true as account creation was successful

        }
        // 5.TODO get List of Account on Ewallet and make sure that not any account with same user name

        // 6.TODO if not exist any account not has same username add account and return true

        // 7.TODO else return false


    @Override
    public boolean loginAccount(Account account) {
        // Retrieve the list of accounts from the wallet
        List<Account> accounts = ewallet.getAccounts();

        // Iterate over the accounts to check for a matching username and password
        for (Account existingAccount : accounts) {
            if (existingAccount.getUserName().equals(account.getUserName())
                    && existingAccount.getPassword().equals(account.getPassword())) {
                System.out.println("Login successful for user: " + account.getUserName());
                return true; // Return true if username and password match
            }
        }

        // If no matching account is found, return false
        System.out.println("Invalid username or password.");
        return false;
    }


    // TODO create function with name deposit that return

    // TODO true if deposit success
    // TODO false if deposit fail
    // TODO check if account exist on wallet or not if not print account not exist
    // TODO check if account is active or not  if not print account not active
    // TODO make deposit

    // TODO without duplication
    @Override
    public boolean withdraw(String userName, double amount) {
        // STEP 1: Check if the account exists in the Ewallet
        Account account = findAccountByUserName(userName);
        if (account == null) {
            System.out.println("Account not exist");
            return false;
        }

        // STEP 2: Check if the account is active
        if (!account.getActive()) {
            System.out.println("Account not active");
            return false;
        }

        // STEP 3: Check if the balance is sufficient
        if (account.getBalance() < amount) {
            System.out.println("Can't withdraw because the balance is less than " + amount);
            return false;
        }

        // STEP 4: Perform withdrawal and update balance
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdrawal successful! " + amount + " has been withdrawn.");
        return true;
    }

    // Helper method to find an account by its username in the Ewallet
    private Account findAccountByUserName(String userName) {
        for (Account account : ewallet.getAccounts()) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null; // Return null if the account does not exist
    }

    // TODO make withdraw
    // TODO create function with name withdraw that return
    // TODO true if withdraw success
    // TODO false if withdraw fail
    // TODO check if account exist on wallet or not if not print account not exist
    // TODO check if account is active or not  if not print account not active
    // TODO check if account balance is greater than  money if not print can't deposit because ....
    // TODO make without


    // Transfer Account depositAccount, Account withdrawAccount, int money
    // TODO without duplication
    // TODO make Transfer
    // TODO create function with name transfer that return
    // TODO true if transfer success
    // TODO false if transfer fail
    // TODO check if depositAccount and withdrawAccount exist on wallet or not if not print account not exist
    // TODO check if depositAccount and withdrawAccount is active or not  if not print account not active
    // TODO check if withdrawAccount balance is greater than money if not print can't deposit because ....

    // TODO SHOW Account Details
    void showAccountDetails(Account account) {
        // Check if the account exists
        if (account == null) {
            System.out.println("Account details unavailable. Account does not exist.");
            return;
        }

        // Display account details
        System.out.println("---- Account Details ----");
        System.out.println("Name: " + account.getUserName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Status: " + (account.getActive() ? "Active" : "Inactive"));
        System.out.println("--------------------------");
    }



    // TODO SHOW show Balance
    void showBalance(Account account) {
        // Check if the account exists
        if (account == null) {
            System.out.println("Account does not exist.");
            return;
        }

        // Display the account balance
        System.out.println("Account Balance: " + account.getBalance());
    }
}
