package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.controller.SessionRequestContent;


import com.siniak.finaltask.service.SearchedPersonService;
import org.apache.logging.log4j.Level;

import java.util.List;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

public class CreateHelpResponseCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        HelpResponseService service = new HelpResponseService();
        SearchedPersonService personService = new SearchedPersonService();
        HelpResponseService helpResponseService = new HelpResponseService();
        Router router = new Router();
        try {
            service.create(createHelpResponse(content));
            SearchedPerson person = personService.findById(Integer.parseInt(content.getParameter(SP_ID_PARAMETR)));
            List<HelpResponse> responses = helpResponseService.findByPersonId(person.getId());
            content.setSessionAttribute(SEARCHED_PERSON_ATTR, person);
            content.setSessionAttribute(HELP_RESPONSES_ATTR, responses);
            router.setRedirect();
            router.setPage(SEARCHED_PERSON_PAGE);
        }  catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        } finally {
            service.finishService();
        }
        return router;
    }

    private HelpResponse createHelpResponse(SessionRequestContent content){
        HelpResponse response = new HelpResponse();
        response.setUserId(Integer.parseInt(content.getParameter(USER_ID_PARAMETR)));
        response.setSearchedPersonId(Integer.parseInt(content.getParameter(SP_ID_PARAMETR)));
        response.setTitle(content.getParameter(TITLE_PARAMETR));
        response.setBody(content.getParameter(BODY_PARAMETR));
        response.setUserLogin(content.getParameter(USER_LOGIN_PARAMETR));
        return response;
    }
}
