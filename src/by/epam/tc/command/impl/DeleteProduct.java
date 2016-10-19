package by.epam.tc.command.impl;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;
import by.epam.tc.bean.requests.DeleteProductRequest;
import by.epam.tc.command.Command;
import by.epam.tc.service.DeleteProductService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;

public class DeleteProduct implements Command {

    @Override
    public Response execute(Request request) {
        DeleteProductRequest deleteProductRequest = null;
        if (request instanceof DeleteProductRequest) {
            deleteProductRequest = (DeleteProductRequest) request;
        }

        if (deleteProductRequest == null) {
            return null;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DeleteProductService deleteProduct = serviceFactory.getDeleteProduct();

        String productName = deleteProductRequest.getProductName();
        String categoryName = deleteProductRequest.getCategoryName();

        Response response = new Response();

        try {
            deleteProduct.delete(categoryName, productName);
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
