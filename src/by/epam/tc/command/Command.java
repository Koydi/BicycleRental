package by.epam.tc.command;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;

public interface Command {
    Response execute(Request request);
}
