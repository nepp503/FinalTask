package com.siniak.finaltask.utils;

import com.siniak.finaltask.manager.ConfigurationManager;
import com.siniak.finaltask.manager.MessageManager;

public class AttributeParameterPathConstant {
    public static final String FORWARD = "FORWARD";
    public static final String URL = "url";
    public static final String UPLOAD_DIR = "uploads";
    public static final String SEPARATOR = "/";
    public static final String COMMAND_PARAMETR = "command";
    public static final String ID_USER_PARAMETR = "iduser";
    public static final String ID_PARAMETR = "id";
    public static final String LOGIN_PARAMETR = "login";
    public static final String USER_LOGIN_PARAMETR = "userlogin";
    public static final String PASSWORD_PARAMETR = "password";
    public static final String EMAIL_PARAMETR = "email";
    public static final String FIRSTNAME_PARAMETR = "firstname";
    public static final String LASTNAME_PARAMETR = "lastname";
    public static final String ROLE_PARAMETR = "role";
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
    public static final String SQL_FAILED_MSG = MessageManager.getProperty("sql.failed");
    public static final String DELETE_USER_FAILED = MessageManager.getProperty("delete.user.error");
    public static final String CREATE_USER_ERROR_MSG = MessageManager.getProperty("create.user.error");
    public static final String FIND_USER_ERROR_MSG = MessageManager.getProperty("find.user.error");
    public static final String UPDATE_USER_ERROR_MSG = MessageManager.getProperty("update.user.error");
    public static final String CREATE_VOLUNTEER_ERROR_MSG = MessageManager.getProperty("create.volunteer.error");
    public static final String FIND_VOLUNTEER_ERROR_MSG = MessageManager.getProperty("find.volunteer.error");
    public static final String UPDATE_VOLUNTEER_ERROR_MSG = MessageManager.getProperty("update.volunteer.error");
    public static final String DELETE_VOLUNTEER_ERROR_MSG = MessageManager.getProperty("delete.volunteer.error");
    public static final String CREATE_PERSON_ERROR_MSG = MessageManager.getProperty("create.person.error");
    public static final String FIND_PERSON_ERROR_MSG = MessageManager.getProperty("find.person.error");
    public static final String UPDATE_PERSON_ERROR_MSG = MessageManager.getProperty("update.person.error");
    public static final String DELETE_PERSON_ERROR_MSG = MessageManager.getProperty("delete.person.error");
    public static final String CREATE_RESPONSE_ERROR_MSG = MessageManager.getProperty("create.response.error");
    public static final String FIND_RESPONSE_ERROR_MSG = MessageManager.getProperty("find.response.error");
    public static final String UPDATE_RESPONSE_ERROR_MSG = MessageManager.getProperty("update.response.error");
    public static final String DELETE_RESPONSE_ERROR_MSG = MessageManager.getProperty("delete.response.error");
    public static final String FILE_DOWNLOAD_ERROR_MSG = MessageManager.getProperty("file.download.failed");
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
    public static final String EDIT_USER_PAGE = ConfigurationManager.getProperty("path.page.edit_user");
    public static final String DATABASE_PATH = "database";

    private AttributeParameterPathConstant() {
    }
}
