package by.epam.tc.bean;

import by.epam.tc.controller.Commands;

public class Request {
    private Commands command;

    public Commands getCommand() {
        return command;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }
}
