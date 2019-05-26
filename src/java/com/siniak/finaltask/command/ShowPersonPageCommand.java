package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import java.util.List;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class ShowPersonPageCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        SearchedPersonService service = new SearchedPersonService();
        HelpResponseService helpResponseService = new HelpResponseService();
        try {
            SearchedPerson person = service.findById(Integer.parseInt(content.getParameter(SP_ID_PARAMETR)));
            List<HelpResponse> responses = helpResponseService.findByPersonId(person.getId());
            content.setRequestAttribute(SEARCHED_PERSON_ATTR, person);
            content.setRequestAttribute(HELP_RESPONSES_ATTR, responses);
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
}
