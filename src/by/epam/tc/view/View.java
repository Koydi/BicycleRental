package by.epam.tc.view;

import by.epam.tc.bean.Request;
import by.epam.tc.bean.Response;
import by.epam.tc.bean.requests.AddProductRequest;
import by.epam.tc.bean.requests.DeleteProductRequest;
import by.epam.tc.bean.requests.EditProductRequest;
import by.epam.tc.bean.requests.ReportProductsRequest;
import by.epam.tc.controller.Commands;
import by.epam.tc.controller.Controller;

import java.util.Scanner;

public class View {
    private static final int ADD_PRODUCT_CONSOLE = 1;
    private static final int DELETE_PRODUCT_CONSOLE = 2;
    private static final int CHANGE_PRODUCT_CONSOLE = 3;
    private static final int REPORT_PRODUCT_CONSOLE = 4;

    private static Controller controller;
    private static Scanner input;

    public static void main(String[] args) {
        controller = new Controller();
        printCommands();
        input = new Scanner(System.in);
        int numberCommand = Integer.parseInt(input.next());
        while (numberCommand != 0) {
            Request request = getRequest(numberCommand);
            if (request != null) {
                Response response = controller.doAction(request);
                handleResponse(response);
            }
            printCommands();
            numberCommand = Integer.parseInt(input.next());
        }

    }

    private static void handleResponse(Response response) {
        if (response.isErrorStatus()) {
            System.out.println(response.getErrorMessage());
        } else {
            System.out.println(response.getMessage());
        }
    }

    private static String getString(String text) {
        String result;
        System.out.println(text);
        result = input.next();
        return result;
    }

    private static void fillAddRequest(AddProductRequest addProductRequest) {
        addProductRequest.setCommand(Commands.ADD_PRODUCT);
        String temp;

        temp = getString("Fill name");
        addProductRequest.setProductName(temp);

        temp = getString("Fill category name");
        addProductRequest.setCategoryName(temp);

        temp = getString("Fill number products");
        addProductRequest.setNumber(temp);

        temp = getString("Fill cost");
        addProductRequest.setCost(temp);

    }

    private static void fillDeleteRequest(DeleteProductRequest deleteProductRequest) {
        deleteProductRequest.setCommand(Commands.DELETE_PRODUCT);
        String temp;

        temp = getString("Fill name");
        deleteProductRequest.setProductName(temp);

        temp = getString("Fill category name");
        deleteProductRequest.setCategoryName(temp);
    }

    private static void fillEditRequest(EditProductRequest editProductRequest) {
        String temp;

        temp = getString("Fill name product to change");
        editProductRequest.setChangedProductName(temp);

        temp = getString("Fill name category of product to change");
        editProductRequest.setChangedProductCategoryName(temp);

        fillAddRequest(editProductRequest);
        editProductRequest.setCommand(Commands.EDIT_PRODUCT);
    }

    private static void fillReportRequest(ReportProductsRequest reportProductsRequest) {
        reportProductsRequest.setCommand(Commands.REPORT_PRODUCTS);
    }

    private static Request getRequest(int numberCommand) {
        Request result;
        switch(numberCommand) {
            case ADD_PRODUCT_CONSOLE:
                result = new AddProductRequest();
                fillAddRequest((AddProductRequest) result);
                break;
            case DELETE_PRODUCT_CONSOLE:
                result = new DeleteProductRequest();
                fillDeleteRequest((DeleteProductRequest) result);
                break;
            case CHANGE_PRODUCT_CONSOLE:
                result = new EditProductRequest();
                fillEditRequest((EditProductRequest) result);
                break;
            case REPORT_PRODUCT_CONSOLE:
                result = new ReportProductsRequest();
                fillReportRequest((ReportProductsRequest) result);
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    private static void printCommands() {
        System.out.println("Enter 1 - to add product");
        System.out.println("Enter 2 - to delete product");
        System.out.println("Enter 3 - to change product");
        System.out.println("Enter 4 - to report products");
        System.out.println("Enter 0 - to exit");
    }
}
