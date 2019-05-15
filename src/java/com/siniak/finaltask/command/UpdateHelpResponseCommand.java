package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class UpdateHelpResponseCommand implements Command{
    @Override
    public Router execute(SessionRequestContent content) {
        HelpResponseService service = new HelpResponseService();
        Router router = new Router();
        try {
            service.update(updateHelpResponse(content));
            router.setPage(VOLUNTEER_PAGE);
        }  catch (DaoException e) {
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }

    private HelpResponse updateHelpResponse(SessionRequestContent content){
        HelpResponse response = new HelpResponse();
        response.setId(Integer.parseInt(content.getParameter(RESPONSE_ID_PARAMETR)));
        response.setTitle(content.getParameter(TITLE_PARAMETR));
        response.setBody(content.getParameter(BODY_PARAMETR));
        return response;
    }
}
