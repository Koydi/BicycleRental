package by.epam.tc.service.impl;

import by.epam.tc.dao.DAOFactory;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.dao.impl.DataBaseDAO;
import by.epam.tc.service.DeleteProductService;
import by.epam.tc.service.exception.ServiceException;

public class DeleteProduct implements DeleteProductService {

    @Override
    public void delete(String categoryName, String name) throws ServiceException {
        // проверка входных данных
        DAOFactory daoFactory = DAOFactory.getInstance();
        DataBaseDAO dataBaseDAO = daoFactory.getDataBaseDAO();
        try {
            dataBaseDAO.deleteProduct(categoryName, name);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
