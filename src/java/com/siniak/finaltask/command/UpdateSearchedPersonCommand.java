package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class UpdateSearchedPersonCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        SearchedPersonService service = new SearchedPersonService();
        Router router = new Router();
        try {
            SearchedPerson person = service.update(updateSearchedPerson(content));
            content.setRequestAttribute(SEARCHED_PERSON_ATTR, person);
            router.setRedirect();
            router.setPage(SEARCHED_PERSON_PAGE);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }

    private SearchedPerson updateSearchedPerson(SessionRequestContent content){
        SearchedPerson person = new SearchedPerson();
        person.setId(Integer.parseInt(content.getParameter(ID_PARAMETR)));
        person.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        person.setLastName(content.getParameter(LASTNAME_PARAMETR));
        person.setBirthPlace(content.getParameter(BIRTH_PLACE_PARAMETR));
        person.setSearchArea(content.getParameter(SEARCH_AREA_PARAMETR));
        person.setSpecialSigns(content.getParameter(SPECIAl_SIGNS_PARAMETR));
        person.setPhoto(content.getParameter(PHOTO_PARAMETR));
//        person.setFound(); //todo
        return person;
    }
}