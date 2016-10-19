package by.epam.tc.command.impl;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;
import by.epam.tc.bean.requests.AddProductRequest;
import by.epam.tc.command.Command;
import by.epam.tc.service.AddProductService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;

public class AddProduct implements Command {

    @Override
    public Response execute(Request request) {
        AddProductRequest addProductRequest = null;
        if (request instanceof AddProductRequest) {
            addProductRequest = (AddProductRequest) request;
        }

        if (addProductRequest == null) {
            return null;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AddProductService addProduct = serviceFactory.getAddProduct();

        String productName = addProductRequest.getProductName();
        String categoryName = addProductRequest.getCategoryName();
        String cost = addProductRequest.getCost();
        String number = addProductRequest.getNumber();

        Response response = new Response();
        try {
            addProduct.add(categoryName, productName, cost, number);
            response.setErrorStatus(false);
            response.setMessage("Successfully");
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }
}
