package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

public class EditPersonCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        SearchedPersonService service = new SearchedPersonService();
        try {
            if (content.getParameter(SP_ID_PARAMETR) != null) {
                SearchedPerson person = service.findById(Integer.parseInt(content.getParameter(SP_ID_PARAMETR)));
                content.setRequestAttribute(SEARCHED_PERSON_ATTR, person);
            }
            router.setPage(EDIT_PERSON_PAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }finally {
            service.finishService();
        }
        return router;
    }
}
