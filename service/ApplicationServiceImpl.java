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
        if (!validationService.validateUserName(name)) { // "eslam"
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
        account.setUserName(name);
        account.setPassword(password);
        boolean isAccountCreated = accountService.createAccount(account);
        if (!isAccountCreated) {
            System.out.println("Account Created");
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
        // 8.TODO SERVICE OF ACCOUNT TO LOGIN
        if (accountService.loginAccount(new Account(name, password))) {
            System.out.println("Login Success");
            services();
        } else {
            System.out.println("Account not Exist");
        }
    }

    private void services() {

        System.out.println("1.Deposit   2.Withdraw    3.show details    4.Transfer    5. show balance   6.exit  7.logout");

        // TODO create switch case such as on run function
        // TODO every case on switch call function  don't forget (Invalid choose)
        int counter=0;
        while (counter < 0)
        {
            int choose = scanner.nextInt();
            //#######
        }
    }

    // TODO create deposit function
    void deposit(Account a){
        // input int money
        Scanner scanner = new Scanner(System.in);
        double mo = scanner.nextDouble();
        // TODO pls validate money >= 100 and <= 20000
        if(mo >= 100 && mo <= 20000)
        {
            // i dont know what is the next step
        }

    }

    // TODO create Withdraw function
    void withdraw(Account a){
         int money = scanner.nextInt();   // input int money
        // TODO pls validate money >= 100 and <= 8000
        System.out.println("Please Enter your number of money from 100 to 8000 in once");

        if(money<a.getBalance())
        {
            if(money >= 100 && money <= 8000){
                System.out.println("Withdraw is successful \nyour balance now is : "+(a.getBalance()- money));
            }
            else {
                System.out.println("sorry but number of money must be from 100 to 8000..... try again");
            }
        }
    }

    void showDetails(Account a){

    }

    void transfer(Account withdrawAccount){
        // TODO USER MUST give me user name of account that will transfer
        // TODO input Account depositAccount
        // TODO input int money


    }

    void showBalance(Account a){
        System.out.println("Your Balance is : " + a.getBalance());
    }
}
