package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.SessionRequestContent;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.COMMAND_PARAMETR;

public class CommandFactory {

    public Command defineCommand(SessionRequestContent content) {
        Command current = new EmptyCommand();
        String userCommand = null;
        userCommand = content.getParameter(COMMAND_PARAMETR);
        if (userCommand == null || userCommand.isEmpty()) {
            return current;
        }
        CommandEnum currentEnum = CommandEnum.valueOf(userCommand.toUpperCase());
        current = currentEnum.getCurrentCommand();
        return current;
    }
}
