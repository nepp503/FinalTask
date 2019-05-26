package com.siniak.finaltask.dao.query;

public class UserQuery {
    public final static String FIND_ALL_USERS = "SELECT iduser, login, password, email, firstname, lastname, role" +
            " FROM users";
    public static final String FIND_USER_BY_ID = "SELECT iduser, login, password, email, firstname, lastname, role" +
            " FROM users WHERE iduser=?";
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT " +
            "iduser, login, password, email, firstname, lastname, role" +
            " FROM users WHERE login=? AND password=?";
    public final static String INSERT_USER = "INSERT INTO users(login, password, email, " +
            "firstname, lastname) VALUES(?,?,?,?,?)";
    public final static String DELETE_USER = "DELETE FROM users WHERE iduser=?";
    public final static String UPDATE_USER = "UPDATE users " +
            "SET login=?, firstname=?, lastname=?, email=? " +
            "WHERE iduser=?";
}
