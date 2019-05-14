package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.VolunteerService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;

public class FindVolunteersCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        VolunteerService service = new VolunteerService();
        Router router = new Router();
        try {
            List<Volunteer> people = service.findAll();
            content.setRequestAttribute(LIST_VOLUNTEER_ATTR, people);
            router.setPage(VOLUNTEERS_PAGE);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
