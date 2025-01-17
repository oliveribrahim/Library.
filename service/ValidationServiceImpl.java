package main.project.service;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUserName(String userName) {

        // TODO return true if userName start with upper case and length must be greater than or equal 3
        // else false
        return false;
    }

    @Override
    public boolean validatePassword(String password) {
        // TODO return true if password contain number , uppercaseChar, lowerCase char, size greater than or equal 6 and special char
        // else false
        return false;
    }
}
