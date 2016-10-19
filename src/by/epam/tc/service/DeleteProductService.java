package by.epam.tc.service;

import by.epam.tc.service.exception.ServiceException;

public interface DeleteProductService {
    void delete(String categoryName, String name) throws ServiceException;
}
