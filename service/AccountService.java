package main.project.service;

import main.project.model.Account;

public interface AccountService {

    boolean createAccount(Account account);
    boolean loginAccount(Account account);

    // TODO without duplication
    boolean withdraw(String userName, double amount);
}
