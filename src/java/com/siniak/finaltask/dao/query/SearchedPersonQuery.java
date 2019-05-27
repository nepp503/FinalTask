package com.siniak.finaltask.dao.query;

/**
 * Queries for SearchedPersonDao
 * @author Vitali Siniak
 */

public class SearchedPersonQuery {
    public final static String INSERT_SEARCHED_PERSON = "INSERT INTO searchedpeople" +
            "(firstname, lastname, birthplace, searcharea, specialsigns, photo) " +
            "VALUES(?,?,?,?,?,?)";
    public final static String FIND_SEARCHED_PERSON_BY_ID = "SELECT id, firstname, lastname, birthplace, " +
            "searcharea, specialsigns, photo FROM searchedpeople " +
            "WHERE id=?";
    public final static String UPDATE_SEARCHED_PERSON = "UPDATE searchedpeople " +
            "SET firstname=?, lastname=?, birthplace=?, searcharea=?, specialsigns=?, photo=? " +
            "WHERE id=?";
    public final static String DELETE_SEARCHED_PERSON_BY_ID = "DELETE FROM searchedpeople " +
            "WHERE id=?";
    public final static String FIND_ALL_SERCHED_PERSON = "SELECT " +
            "id, firstname, lastname, birthplace, searcharea, specialsigns, photo " +
            "FROM searchedpeople";
    public final static String FIND_PERSON_BY_LASTNAME = "SELECT " +
            "id, firstname, lastname, birthplace, searcharea, specialsigns, photo " +
            "FROM searchedpeople " +
            "WHERE lastname LIKE ?";

    private SearchedPersonQuery() {
    }
}
