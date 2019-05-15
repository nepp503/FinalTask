package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.service.HelpResponseService;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;

public class ShowUserPageCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        UserService service = new UserService();
        HelpResponseService helpResponseService = new HelpResponseService();
        try {
            User user = service.findUserById(Integer.parseInt(content.getParameter(USER_ID_PARAMETR)));
            List<HelpResponse> responses = helpResponseService.findByUserId(user.getId());
            content.setRequestAttribute(USER_ATTR, user);
            content.setRequestAttribute(HELP_RESPONSES_ATTR, responses);
            router.setPage(USER_PAGE);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
