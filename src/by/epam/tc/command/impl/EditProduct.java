package by.epam.tc.command.impl;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;
import by.epam.tc.bean.requests.EditProductRequest;
import by.epam.tc.command.Command;
import by.epam.tc.service.EditProductService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;

public class EditProduct implements Command {

    @Override
    public Response execute(Request request) {
        EditProductRequest editProductRequest = null;
        if (request instanceof EditProductRequest) {
            editProductRequest = (EditProductRequest) request;
        }

        if (editProductRequest == null) {
            return null;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EditProductService editProduct = serviceFactory.getEditProduct();

        String newProductName = editProductRequest.getProductName();
        String newCategoryName = editProductRequest.getCategoryName();
        String newCost = editProductRequest.getCost();
        String newNumber = editProductRequest.getNumber();
        String oldProductName = editProductRequest.getChangedProductName();
        String oldCategoryName = editProductRequest.getChangedProductCategoryName();

        Response response = new Response();

        try {
            editProduct.editProduct(oldCategoryName, oldProductName,
                                    newCategoryName, newProductName, newCost, newNumber);
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
