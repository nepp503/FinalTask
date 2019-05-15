package com.siniak.finaltask.dao.constants;

public class HelpResponseQuery {
    public final static String INSERT_HELP_RESPONSE = "INSERT helpresponse" +
            "(userid, personid, title, body, userlogin) " +
            "VALUES(?,?,?,?,?)";
    public final static String FIND_HELP_RESPONSE_BY_ID = "SELECT id, userid, personid, title, body, userlogin " +
            "FROM helpresponse " +
            "WHERE id=?";
    public final static String UPDATE_HELP_RESPONSE = "UPDATE helpresponse " +
            "SET title=?, body=? " +
            "WHERE id=?";
    public final static String DELETE_HELP_RESPONSE_BY_ID = "DELETE FROM helpresponse " +
            "WHERE id=?";
    public final static String FIND_ALL_HELP_RESPONSES = "SELECT " +
            "id, userid, personid, title, body, userlogin " +
            "FROM helpresponse";
    public final static String FIND_HELP_RESPONSE_BY_PERSON_ID = "SELECT id, userid, personid, title, body, userlogin " +
            "FROM helpresponse " +
            "WHERE personid=?";
    public final static String FIND_HELP_RESPONSE_BY_USER_ID = "SELECT id, userid, personid, title, body, userlogin " +
            "FROM helpresponse " +
            "WHERE userid=?";
}
