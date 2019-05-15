package com.siniak.finaltask.command;

import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class DeleteHelpResponseCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        HelpResponseService service = new HelpResponseService();
        Router router = new Router();
        try {
            service.deleteById(Integer.parseInt(content.getParameter(RESPONSE_ID_PARAMETR)));
            router.setPage(SEARCHED_PERSON_PAGE);
        } catch (DaoException e) {
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
