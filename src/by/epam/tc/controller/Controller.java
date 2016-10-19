package by.epam.tc.controller;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;
import by.epam.tc.command.Command;

public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public Response doAction(Request request) {
        Commands executeCommand = request.getCommand();
        Command command = commandProvider.getCommand(executeCommand);
        Response response = command.execute(request);
        return response;
    }
}
