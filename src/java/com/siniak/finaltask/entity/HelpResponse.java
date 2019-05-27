package com.siniak.finaltask.entity;

/**
 * HelpResponse entity
 * @author Vitali Siniak
 */
public class HelpResponse extends Entity {
    private int id;
    private int userId;
    private int searchedPersonId;
    private String title;
    private String body;
    private String userLogin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSearchedPersonId() {
        return searchedPersonId;
    }

    public void setSearchedPersonId(int searchedPersonId) {
        this.searchedPersonId = searchedPersonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
