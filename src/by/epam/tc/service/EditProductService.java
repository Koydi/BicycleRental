package by.epam.tc.service;

import by.epam.tc.service.exception.ServiceException;

public interface EditProductService {
    void editProduct(String categoryName, String name, String newCategoryName,
                     String newProductName, String newCost, String newNumber) throws ServiceException;
}
