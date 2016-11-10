package by.epam.tc.controller;

import by.epam.tc.command.Command;
import by.epam.tc.command.impl.AddProduct;
import by.epam.tc.command.impl.DeleteProduct;
import by.epam.tc.command.impl.EditProduct;
import by.epam.tc.command.impl.ReportProducts;

import java.util.HashMap;

public class CommandProvider {
    private HashMap<Commands, Command> commands = new HashMap();

    CommandProvider() {// public класс, friendly единственный конструктор - зачем? 
        commands.put(Commands.ADD_PRODUCT, new AddProduct());
        commands.put(Commands.DELETE_PRODUCT, new DeleteProduct());
        commands.put(Commands.EDIT_PRODUCT, new EditProduct());
        commands.put(Commands.REPORT_PRODUCTS, new ReportProducts());
    }

    public Command getCommand(Commands command) {
        Command result;
        result = commands.get(command);
        return result;
    }
}
