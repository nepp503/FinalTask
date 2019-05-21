package com.siniak.finaltask.command;

import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;
import static com.siniak.finaltask.constant.Constant.ERROR_PAGE;

public class DeleteSearchedPersonCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        SearchedPersonService service = new SearchedPersonService();
        Router router = new Router();
        try {
            service.deleteById(Integer.parseInt(content.getParameter(SP_ID_PARAMETR)));
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
