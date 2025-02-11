package main.project.service;

import main.project.model.Account;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome Sir");

        // 1.TODO please apply mulite choose for 4 times ##Done
        System.out.println("Please Enter your choose");
        System.out.println("a.login     b.signup   c.exit");
        int a= 0;
        while (a<4)
        {
            char choose = scanner.next().charAt(0);
            switch (choose) {
                case 'a':
                    login();
                    break;
                case 'b':
                    signup();
                    break;
                case 'c':
                    System.out.println("you are welcome.");
                    break;
                default:
                    System.out.println("Invalid Choose ... try again");
            }
            a++;
        }
        System.out.println("Thanks for using E-wallet ... Try again in other time");
    }

    private void signup() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter User name");
        String name = scanner.nextLine();

        System.out.println("Please Enter password");
        String password = scanner.nextLine();

        ValidationService validationService = new ValidationServiceImpl();

        // 2.TODO Validation on UserName and Password
        if (!validationService.validateUserName(name)) { //default false "eslam"
            System.out.println("Invalid UserName");
            return;
        }
        if (!validationService.validatePassword(password)) {
            System.out.println("Invalid Password");
            return;
        }

        // 3.TODO SERVICE OF ACCOUNT TO CREATE ACCOUNT

        AccountService accountService = new AccountServiceImpl();
        Account account = new Account(name, password);
        // 4.TODO   impl createAccount

        boolean isAccountCreated = accountService.createAccount(account);
        if (isAccountCreated) {
            System.out.println("Account Created");
            run();
        } else {
            System.out.println("Account not Created Because There exist account with same user name");
        }

    }

    private void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter User name");
        String name = scanner.nextLine();

        System.out.println("Please Enter password");
        String password = scanner.nextLine();

        ValidationService validationService = new ValidationServiceImpl();

        // TODO Validation on UserName and Password
        if (!validationService.validateUserName(name)) {
            System.out.println("Invalid UserName");
            return;
        }

        if (!validationService.validatePassword(password)) {
            System.out.println("Invalid Password");
            return;
        }

        AccountService accountService = new AccountServiceImpl();
        Account account = new Account();
        // 8.TODO SERVICE OF ACCOUNT TO LOGIN
        if (!accountService.loginAccount(account)) {
            System.out.println("Login Success");
            services(account);
        } else {
            System.out.println("Account not Exist");
        }
    }

    private void services(Account account) {
        Scanner scanner = new Scanner(System.in); // Ensure you have a scanner initialized

        System.out.println("1. Deposit   2. Withdraw   3. Show Details   4. Transfer   5. Show Balance   6. Exit   7. Logout");
        int counter = 0;

        while (counter <= 4) {
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next(); // Consume the invalid input to avoid infinite loop
                continue; // Skip to the next iteration
            }
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    deposit(account); // Call deposit method
                    break;
                case 2:
                    withdraw(account); // Call withdraw method
                    break;
                case 3:
                    showDetails(account); // Call show details method
                    break;
                case 4:
                    transfer(account); // Call transfer method
                    break;
                case 5:
                    showBalance(account); // Call show balance method
                    break;
                case 6:
                    System.out.println("Exiting services. Thank you!");
                    return; // Exit the method to stop further execution
                case 7:
                    logout(); // Call logout method
                    break; // Exit the method after logout
                default:
                    System.out.println("Invalid choice, please try again!!");
            }

            counter++;
        }
    }


    // TODO create deposit function
    void deposit(Account a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount to deposit (between 100 and 20000):");
        double mo = scanner.nextDouble(); // Input the deposit amount

        // Validate the deposit amount
        if (mo >= 100 && mo <= 20000) {
            // Update the account balance
            a.setBalance(a.getBalance() + mo); // Add the deposit amount to the balance
            System.out.println("Deposit successful!");
            System.out.println("Your new balance is: " + a.getBalance());
        } else {
            // If the input amount is invalid
            System.out.println("Invalid amount. Please enter a value between 100 and 20000.");
        }
    }


    // TODO create Withdraw function
    void withdraw(Account account) {
        System.out.println("Please enter the amount to withdraw (between 100 and 8000):");
        int money = scanner.nextInt(); // Input the withdrawal amount

        // Validate the input amount
        if (money >= 100 && money <= 8000) {
            // Check if the account has enough balance
            if (money <= account.getBalance()) {
                // Perform the withdrawal
                account.setBalance(account.getBalance() - money); // Deduct the amount from the account balance
                System.out.println("Withdrawal successful!");
                System.out.println("Your new balance is: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance. Your current balance is: " + account.getBalance());
            }
        } else {
            System.out.println("Invalid amount. Please enter a value between 100 and 8000.");
        }
    }


    void showDetails(Account account) {
        if (account == null) {
            System.out.println("Account details unavailable. Please ensure the account is valid.");
            return;
        }
        if(account.getUserName() == null)
        {account.setUserName("Unknown");}
        else{account.setUserName(account.getUserName());}

        double balance = account.getBalance() >= 0 ? account.getBalance() : 0.0; // Ensure non-negative balance
        String activeStatus = account.getActive() ? "Active" : "Inactive"; // Handle boolean status


        System.out.println("Account Details:");
        System.out.println("Name: " + account.getUserName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Active: " + account.getActive()); // If there's an ID field
    }


    void transfer(Account withdrawAccount){
        // TODO USER MUST give me user name of account that will transfer
        // TODO input Account depositAccount
        // TODO input int money


    }

    void showBalance(Account account){
        System.out.println("Your Balance now is : " + account.getBalance());
    }

    void logout() {
        System.out.println("Thanks for using E-Wallet System");
        run();
    }
}
