package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.controller.SessionRequestContent;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.LANGUAGE_PARAMETR;
import static com.siniak.finaltask.utils.AttributeParameterPathConstant.LOCALE_ATTR;

public class LanguageCommand implements Command {

    @Override
    public Router execute(SessionRequestContent requestContent) {
        Router router = new Router();
        String locale = requestContent.getParameter(LANGUAGE_PARAMETR);
        requestContent.setSessionAttribute(LOCALE_ATTR, locale);
        return router;
    }
}
