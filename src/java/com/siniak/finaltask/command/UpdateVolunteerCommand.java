package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.LoadImageService;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class UpdateVolunteerCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        VolunteerService service = new VolunteerService();
        Router router = new Router();
        try {
            Volunteer volunteer = service.update(updateVolunteer(content));
            content.setSessionAttribute(VOLUNTEER_ATTR, volunteer);
            router.setRedirect();
            router.setPage(VOLUNTEER_PAGE);
        }  catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }finally {
            service.finishService();
        }
        return router;
    }

    private Volunteer updateVolunteer(SessionRequestContent content) throws ServiceException {
        Volunteer volunteer = new Volunteer();
        LoadImageService loadService = new LoadImageService();
        volunteer.setId(Integer.parseInt(content.getParameter(VOLUNTEER_ID_PARAMETR)));
        volunteer.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        volunteer.setLastName(content.getParameter(LASTNAME_PARAMETR));
        volunteer.setYearsOfWork(Integer.parseInt(content.getParameter(YEARS_OF_WORK_PARAMETR)));
        volunteer.setNumberOfOperations(Integer.parseInt(content.getParameter(NUMBER_OF_OPERATIONS_PARAMETR)));
        volunteer.setPhoto(loadService.loadImage(content.getParts(), content.getContextPath()));
        return volunteer;
    }
}
