package com.siniak.finaltask.command;

import com.siniak.finaltask.utils.SessionRequestContent;

import static com.siniak.finaltask.constant.Constant.LANGUAGE_PARAMETR;
import static com.siniak.finaltask.constant.Constant.LOCALE_ATTR;

public class LanguageCommand implements Command {

    @Override
    public Router execute(SessionRequestContent requestContent) {
        Router router = new Router();
        String locale = requestContent.getParameter(LANGUAGE_PARAMETR);
        requestContent.setSessionAttribute(LOCALE_ATTR, locale);
        return router;
    }
}
