package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.LoadImageService;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class UpdateUserCommand implements Command{
    @Override
    public Router execute(SessionRequestContent content) {
        UserService service = new UserService();
        LoadImageService loadService = new LoadImageService();
        Router router = new Router();
        try {
            User user = service.update(updateUser(content));
            content.setSessionAttribute(USER_ATTR, user);
            router.setRedirect();
            router.setPage(USER_PAGE);
        }  catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }finally {
            service.finishService();
        }
        return router;
    }

    private User updateUser(SessionRequestContent content){
        User user = new User();
        user.setId(Integer.parseInt(content.getParameter(USER_ID_PARAMETR)));
        user.setLogin(content.getParameter(LOGIN_PARAMETR));
        user.setEmail(content.getParameter(EMAIL_PARAMETR));
        user.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        user.setLastName(content.getParameter(LASTNAME_PARAMETR));
//        user.setPhoto;
        return user;
    }
}
