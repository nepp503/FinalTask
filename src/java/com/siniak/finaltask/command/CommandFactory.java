package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.SessionRequestContent;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.COMMAND_PARAMETR;

/**
 * Command factory.
 * @author Vitali Siniak
 */

public class CommandFactory {
    /**
     * Select command according to specific parameter.
     * @param content
     * @see SessionRequestContent
     * @return
     * @see Command
     */
    public Command defineCommand(SessionRequestContent content) {
        Command current = new EmptyCommand();
        String userCommand;
        userCommand = content.getParameter(COMMAND_PARAMETR);
        if (userCommand == null || userCommand.isEmpty()) {
            return current;
        }
        CommandEnum currentEnum = CommandEnum.valueOf(userCommand.toUpperCase());
        current = currentEnum.getCurrentCommand();
        return current;
    }
}
