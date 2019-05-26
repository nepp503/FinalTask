package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Command {
    Logger logger = LogManager.getLogger();

    Router execute(SessionRequestContent content);
}
