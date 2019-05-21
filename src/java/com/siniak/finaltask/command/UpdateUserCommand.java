package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;
import static com.siniak.finaltask.constant.Constant.BODY_PARAMETR;

public class UpdateUserCommand implements Command{
    @Override
    public Router execute(SessionRequestContent content) {
        UserService service = new UserService();
        Router router = new Router();
        try {
            service.update(updateUser(content));
            router.setPage(USER_PAGE);
        }  catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }

    private User updateUser(SessionRequestContent content){
        User user = new User();
        user.setLogin(content.getParameter(LOGIN_PARAMETR));
        user.setEmail(content.getParameter(EMAIL_PARAMETR));
        user.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        user.setLastName(content.getParameter(LASTNAME_PARAMETR));
        return user;
    }
}
