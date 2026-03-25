package org.example.TDD;

public class PasswordValidator {

    private static final int MINIMUN_LENGTH =8;

    public boolean isValid(String password){
        return hasMinimumLength(password);
    }

    public boolean hasMinimumLength(String password){
        return password.length() >= MINIMUN_LENGTH;
    }
}
