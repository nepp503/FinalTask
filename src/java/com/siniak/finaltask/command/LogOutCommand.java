package com.siniak.finaltask.command;

import com.siniak.finaltask.utils.SessionRequestContent;

import static com.siniak.finaltask.constant.Constant.USER_ATTR;

public class LogOutCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        content.removeSessionAttribute(USER_ATTR);
        router.setRedirect();
        return router;
    }
}
