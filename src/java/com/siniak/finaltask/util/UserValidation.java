package com.siniak.finaltask.util;

import com.siniak.finaltask.entity.User;

/**
 * Validation for users
 * @author Vitali Siniak
 */

public class UserValidation {
    private static final String LOGIN_PATTERN = "^([a-zA-Z]+)[a-zA-Z\\d_]{4,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+";

    /**
     * Checks if user valid or not
     * @param user
     * @see User
     * @return true, if user is valid, false - otherwise
     */
    public boolean isValid(User user) {
        return isLoginValid(user.getLogin()) && isPasswordValid(user.getPassword()) && isEmailValid(user.getEmail());
    }

    /**
     * Checks if user update valid or not
     * @param user
     * @see User
     * @return true, if user update is valid, false - otherwise
     */
    public boolean isUpdateValid(User user) {
        return isLoginValid(user.getLogin()) && isEmailValid(user.getEmail());
    }

    private boolean isLoginValid(String login) {
        if (login.matches(LOGIN_PATTERN) && login.length() < 45) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordValid(String password) {
        if (password.matches(PASSWORD_PATTERN) && password.length() < 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailValid(String email) {
        if (email.matches(EMAIL_PATTERN) && email.length() < 100) {
            return true;
        } else {
            return false;
        }
    }
}
