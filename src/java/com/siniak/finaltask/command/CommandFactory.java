package com.siniak.finaltask.command;

import com.siniak.finaltask.utils.SessionRequestContent;

public class CommandFactory {
    private static final String COMMAND_PARAMETR = "command";

    public Command defineCommand(SessionRequestContent content) {
        Command current = new EmptyCommand();
        String userCommand = null;
        userCommand = content.getParameter(COMMAND_PARAMETR);
        System.out.println(userCommand);
        if (userCommand == null || userCommand.isEmpty()) {
            return current;
        }
        CommandEnum currentEnum = CommandEnum.valueOf(userCommand.toUpperCase());
        current = currentEnum.getCurrentCommand();
        return current;
    }
}
