package by.epam.tc.command.impl;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;
import by.epam.tc.bean.entity.ReportCategoryResult;
import by.epam.tc.bean.requests.ReportProductsRequest;
import by.epam.tc.command.Command;
import by.epam.tc.service.ReportProductsService;
import by.epam.tc.service.exception.ServiceException;
import by.epam.tc.service.factory.ServiceFactory;

import java.util.List;

public class ReportProducts implements Command {

    @Override
    public Response execute(Request request) {
        ReportProductsRequest reportProductsRequest = null;
        if (request instanceof ReportProductsRequest) {
            reportProductsRequest = (ReportProductsRequest) request;
        }

        if (reportProductsRequest == null) {
            return null;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReportProductsService reportProducts = serviceFactory.getReportProducts();

        Response response = new Response();

        try {
            List<ReportCategoryResult> temp = reportProducts.report();
            response.setReportCategoryResult(temp);
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
