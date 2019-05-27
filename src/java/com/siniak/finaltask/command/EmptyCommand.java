package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.controller.SessionRequestContent;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.ERROR_PAGE;

public class EmptyCommand implements Command {
    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        router.setPage(ERROR_PAGE);
        return router;
    }
}
