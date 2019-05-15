package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.utils.SessionRequestContent;
import com.sun.xml.internal.ws.api.message.HeaderList;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class CreateHelpResponseCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        HelpResponseService service = new HelpResponseService();
        Router router = new Router();
        try {
            service.create(createHelpResponse(content));
            router.setPage(VOLUNTEER_PAGE);
        }  catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
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