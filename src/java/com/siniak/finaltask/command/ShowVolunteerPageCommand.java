package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.SearchedPersonService;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;
import static com.siniak.finaltask.constant.Constant.ERROR_PAGE;

public class ShowVolunteerPageCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        VolunteerService service = new VolunteerService();
        try {
            Volunteer volunteer = service.findById(Integer.parseInt(content.getParameter(VOLUNTEER_ID_PARAMETR)));
            content.setRequestAttribute(VOLUNTEER_ATTR, volunteer);
            router.setPage(VOLUNTEER_PAGE);
        } catch (DaoException e) {
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
