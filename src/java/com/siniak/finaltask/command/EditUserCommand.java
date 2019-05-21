package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class EditUserCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        UserService service = new UserService();
        try {
            if (content.getParameter(USER_ID_PARAMETR) != null) {
                User user = service.findUserById(Integer.parseInt(content.getParameter(USER_ID_PARAMETR)));
                content.setSessionAttribute(USER_ATTR, user);
            }
            router.setPage(EDIT_USER_PAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
