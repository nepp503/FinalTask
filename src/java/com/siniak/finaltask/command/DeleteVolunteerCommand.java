package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

public class DeleteVolunteerCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        VolunteerService service = new VolunteerService();
        Router router = new Router();
        try {
            service.deleteById(Integer.parseInt(content.getParameter(VOLUNTEER_ID_PARAMETR)));
            router.setRedirect();
        }finally {
            service.finishService();
        }
        return router;
    }
}
