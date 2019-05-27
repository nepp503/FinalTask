package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Interface Command defines one method execute(), defines the action with the certain type of command.
 * Implements Command pattern.
 * @author Vitali Siniak
 */
public interface Command {
    Logger logger = LogManager.getLogger();

    /**
     * Method that defines actions according to certain type of command
     * @param content
     * @see SessionRequestContent
     * @return
     * @see Router
     */
    Router execute(SessionRequestContent content);
}
