package com.siniak.finaltask.dao.constants;

public class UserQuery {
    public final static String FIND_ALL_USERS = "SELECT * FROM users";
    public static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE iduser=?";
    public static final String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=? AND password=?";
    public final static String INSERT_USER = "INSERT INTO users(login, password, email, " +
            "firstname, lastname) VALUES(?,?,?,?,?)";
    public final static String DELETE_USER = "INSERT FROM users WHERE login=?";
}
