package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import java.util.List;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

public class FindSearchedPersonCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        SearchedPersonService service = new SearchedPersonService();
        Router router = new Router();
        try {
            String name = content.getParameter(SEARCH_ATTR);
            List<SearchedPerson> people = service.findPersonByNamePart(name);
            content.setRequestAttribute(SEARCH_NAME_ATTR, name);
            content.setRequestAttribute(LIST_FIND_ATTR, people);
            router.setPage(FIND_RESULT_PAGE);
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
