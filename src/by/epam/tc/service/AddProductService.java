package by.epam.tc.service;

import by.epam.tc.service.exception.ServiceException;

public interface AddProductService {
    void add(String categoryName, String name, String cost, String number) throws ServiceException;
}
