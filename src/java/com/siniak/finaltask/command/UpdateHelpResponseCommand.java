package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class UpdateHelpResponseCommand implements Command{
    @Override
    public Router execute(SessionRequestContent content) {
        HelpResponseService service = new HelpResponseService();
        Router router = new Router();
        try {
            service.update(updateHelpResponse(content));
            router.setPage(SEARCHED_PERSON_PAGE);
        }  catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }finally {
            service.finishService();
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
