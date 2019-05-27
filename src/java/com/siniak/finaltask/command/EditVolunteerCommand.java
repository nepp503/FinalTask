package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

public class EditVolunteerCommand implements Command {
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        VolunteerService service = new VolunteerService();
        try {
            if (content.getParameter(VOLUNTEER_ID_PARAMETR) != null) {
                Volunteer volunteer = service.findById(Integer.parseInt(content.getParameter(VOLUNTEER_ID_PARAMETR)));
                content.setRequestAttribute(VOLUNTEER_ATTR, volunteer);
            }
            router.setPage(EDIT_VOLUNTEER_PAGE);
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
