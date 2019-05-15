package com.siniak.finaltask.constant;

import com.siniak.finaltask.manager.ConfigurationManager;
import com.siniak.finaltask.manager.MessageManager;

public class Constant {
    public static final String ID_PARAMETR = "id";
    public static final String LOGIN_PARAMETR = "login";
    public static final String USER_LOGIN_PARAMETR = "userlogin";
    public static final String PASSWORD_PARAMETR = "password";
    public static final String EMAIL_PARAMETR = "email";
    public static final String FIRSTNAME_PARAMETR = "firstname";
    public static final String LASTNAME_PARAMETR = "lastname";
    public static final String BIRTH_PLACE_PARAMETR = "birthplace";
    public static final String SEARCH_AREA_PARAMETR = "searcharea";
    public static final String SPECIAl_SIGNS_PARAMETR = "specialsigns";
    public static final String YEARS_OF_WORK_PARAMETR = "yearsofwork";
    public static final String NUMBER_OF_OPERATIONS_PARAMETR = "numberofoperations";
    public static final String PHOTO_PARAMETR = "photo";
    public static final String USER_ID_PARAMETR = "userid";
    public static final String SP_ID_PARAMETR = "personid";
    public static final String VOLUNTEER_ID_PARAMETR = "volunteerid";
    public static final String RESPONSE_ID_PARAMETR = "responseid";
    public static final String TITLE_PARAMETR = "title";
    public static final String BODY_PARAMETR = "body";
    public static final String LANGUAGE_PARAMETR = "language";
    public static final String LOCALE_ATTR = "locale";
    public static final String USER_ATTR = "user";
    public static final String SEARCHED_PERSON_ATTR = "searchedperson";
    public static final String LIST_PERSON_ATTR = "listperson";
    public static final String VOLUNTEER_ATTR = "volunteer";
    public static final String LIST_VOLUNTEER_ATTR = "listvolunteer";
    public static final String SEARCH_ATTR = "search";
    public static final String SEARCH_NAME_ATTR = "searchName";
    public static final String HELP_RESPONSE_ATTR = "helpresponse";
    public static final String LIST_FIND_ATTR = "findlist";
    public static final String ERROR_MESSAGE_ATTR = "errorMessage";
    public static final String HELP_RESPONSES_ATTR = "responses";
    public static final String CREATE_USER_ERROR_MSG = MessageManager.getProperty("create.user.error");
    public static final String FIND_USER_ERROR_MSG = MessageManager.getProperty("find.user.error");
    public static final String INDEX_PAGE = ConfigurationManager.getProperty("path.page.index");
    public static final String USER_PAGE = ConfigurationManager.getProperty("path.page.user");
    public static final String SEARCHED_PERSON_PAGE = ConfigurationManager.getProperty("path.page.searchedperson");
    public static final String FIND_RESULT_PAGE = ConfigurationManager.getProperty("path.page.listfind");
    public static final String VOLUNTEER_PAGE = ConfigurationManager.getProperty("path.page.volunteer");
    public static final String PEOPLE_PAGE = ConfigurationManager.getProperty("path.page.people");
    public static final String VOLUNTEERS_PAGE = ConfigurationManager.getProperty("path.page.volunteers");
    public static final String ERROR_PAGE = ConfigurationManager.getProperty("path.page.error");
    public static final String EDIT_PERSON_PAGE = ConfigurationManager.getProperty("path.page.edit_person");
    public static final String EDIT_VOLUNTEER_PAGE = ConfigurationManager.getProperty("path.page.edit_volunteer");
    public static final String DATABASE_PATH = "database";

    private Constant() {
    }
}
