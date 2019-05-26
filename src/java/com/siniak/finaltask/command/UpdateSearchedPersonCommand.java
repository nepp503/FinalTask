package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.LoadImageService;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class UpdateSearchedPersonCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        SearchedPersonService service = new SearchedPersonService();
        Router router = new Router();
        try {
            SearchedPerson person = service.update(updateSearchedPerson(content));
            content.setSessionAttribute(SEARCHED_PERSON_ATTR, person);
            router.setRedirect();
            router.setPage(SEARCHED_PERSON_PAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }finally {
            service.finishService();
        }
        return router;
    }

    private SearchedPerson updateSearchedPerson(SessionRequestContent content) throws ServiceException {
        SearchedPerson person = new SearchedPerson();
        LoadImageService loadService = new LoadImageService();
        person.setId(Integer.parseInt(content.getParameter(SP_ID_PARAMETR)));
        person.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        person.setLastName(content.getParameter(LASTNAME_PARAMETR));
        person.setBirthPlace(content.getParameter(BIRTH_PLACE_PARAMETR));
        person.setSearchArea(content.getParameter(SEARCH_AREA_PARAMETR));
        person.setSpecialSigns(content.getParameter(SPECIAl_SIGNS_PARAMETR));
        person.setPhoto(loadService.loadImage(content.getParts(), content.getContextPath()));
        return person;
    }
}
