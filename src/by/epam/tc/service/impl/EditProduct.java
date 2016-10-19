package by.epam.tc.service.impl;

import by.epam.tc.dao.DAOFactory;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.dao.impl.DataBaseDAO;
import by.epam.tc.service.EditProductService;
import by.epam.tc.service.exception.ServiceException;

public class EditProduct implements EditProductService {

    @Override
    public void editProduct(String categoryName, String name, String newCategoryName,
                            String newProductName, String newCost, String newNumber) throws ServiceException {
        // проверка входных данных
        DAOFactory daoFactory = DAOFactory.getInstance();
        DataBaseDAO dataBaseDAO = daoFactory.getDataBaseDAO();
        try {
            dataBaseDAO.editProduct(name, categoryName, newCategoryName, newProductName, newCost, newNumber);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
