package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class SignUpCommand implements Command{

    private UserService userService = new UserService();

    public SignUpCommand() {
    }

    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        try {
            User user = userService.registerUser(createUser(content));
            content.setSessionAttribute(USER_ATTR, user);
            router.setRedirect();
            router.setPage(USER_PAGE);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }

    private User createUser(SessionRequestContent content){
        User user = new User();
        user.setLogin(content.getParameter(LOGIN_PARAMETR));
        user.setPassword(content.getParameter(PASSWORD_PARAMETR));
        user.setEmail(content.getParameter(EMAIL_PARAMETR));
        user.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        user.setLastName(content.getParameter(LASTNAME_PARAMETR));
        return user;
    }
}
