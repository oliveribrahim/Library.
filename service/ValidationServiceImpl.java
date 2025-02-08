package main.project.service;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUserName(String userName) {

        // TODO return true if userName start with upper case and length must be greater than or equal 3
        return Character.isUpperCase(userName.charAt(0)) && userName.length() >= 3;
        // else false
    }

    @Override
    public boolean validatePassword(String password) {
        // TODO return true if password contain :-
        //  number, done
        //  uppercaseChar,done
        //  lowerCase char,done
        //  special char done
        //  size greater than or equal 6 done
        if (password.length() < 6)
        {
          return false;
        }

        // else false
        else
        {
            for(int i=0; i<password.length(); i++)
            {if(Character.isUpperCase(password.charAt(i))) {return true;}}
            for(int i=0; i<password.length(); i++)
            {if(Character.isLowerCase(password.charAt(i))){return true;}}
            for (int i=0; i<password.length(); i++)
            {if(Character.isDigit(password.charAt(i))){return true;}}
            for(int i=0; i<password.length(); i++)
            {if(Character.isLetterOrDigit(password.charAt(i))){return true;}}
            return true;
        }
    }
}
