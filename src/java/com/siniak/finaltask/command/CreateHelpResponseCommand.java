package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.controller.SessionRequestContent;


import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class CreateHelpResponseCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        HelpResponseService service = new HelpResponseService();
        Router router = new Router();
        try {
            service.create(createHelpResponse(content));
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
