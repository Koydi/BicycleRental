package by.epam.tc.service.factory;

import by.epam.tc.service.impl.AddProduct;
import by.epam.tc.service.impl.DeleteProduct;
import by.epam.tc.service.impl.EditProduct;
import by.epam.tc.service.impl.ReportProducts;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private AddProduct addProduct = new AddProduct();
    private DeleteProduct deleteProduct = new DeleteProduct();
    private EditProduct editProduct = new EditProduct();
    private ReportProducts reportProducts = new ReportProducts();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AddProduct getAddProduct() {
        return addProduct;
    }

    public DeleteProduct getDeleteProduct() {
        return deleteProduct;
    }

    public EditProduct getEditProduct() {
        return editProduct;
    }

    public ReportProducts getReportProducts() {
        return reportProducts;
    }
}
