package com.siniak.finaltask.dao.constants;

public class VolunteerQuery {
    public final static String INSERT_VOLUNTEER = "INSERT volunteers" +
            "(id, firstname, lastname, photo, yearsofwork, numberofoperations) " +
            "VALUES(?,?,?,?,?)";
    public final static String FIND_VOLUNTEER_BY_ID = "SELECT id, firstname, lastname, " +
            "photo, yearsofwork, numberofoperations " +
            "FROM volunteers " +
            "WHERE id=?";
    public final static String UPDATE_VOLUNTEER = "UPDATE volunteers " +
            "SET firstname=?, lastname=?, photo=?, yearsofwork=?, numberofoperations=? " +
            "WHERE id=?";;
    public final static String DELETE_VOLUNTEER_BY_ID = "DELETE FROM volunteers " +
            "WHERE id=?";
    public final static String FIND_ALL_VOLUNTEERS = "SELECT " +
            "id, firstname, lastname, photo, yearsofwork, numberofoperations " +
            "FROM volunteers";
}
