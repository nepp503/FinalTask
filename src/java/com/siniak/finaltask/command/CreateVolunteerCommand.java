package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class CreateVolunteerCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        VolunteerService service = new VolunteerService();
        Router router = new Router();
        try {
            Volunteer volunteer = service.create(createVolunteer(content));
            content.setRequestAttribute(VOLUNTEER_ATTR, volunteer);
            router.setRedirect();
            router.setPage(VOLUNTEER_PAGE);
        }  catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }

    private Volunteer createVolunteer(SessionRequestContent content){
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        volunteer.setLastName(content.getParameter(LASTNAME_PARAMETR));
        volunteer.setPhoto(content.getParameter(PHOTO_PARAMETR));
        volunteer.setYearsOfWork(Integer.parseInt(content.getParameter(YEARS_OF_WORK_PARAMETR)));
        volunteer.setNumberOfOperations(Integer.parseInt(content.getParameter(NUMBER_OF_OPERATIONS_PARAMETR)));
        return volunteer;
    }
}
