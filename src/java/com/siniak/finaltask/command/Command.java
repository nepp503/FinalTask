package com.siniak.finaltask.command;

import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Command {
    static final Logger logger = LogManager.getLogger();

    Router execute(SessionRequestContent content);
}
