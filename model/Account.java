package main.project.model;

public class Account {

    private String userName;
    private String password;
    private double balance;
    private boolean active;

    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.balance = 0;
        this.active = true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
