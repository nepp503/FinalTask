package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;

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
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
