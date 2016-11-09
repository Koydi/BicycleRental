package by.epam.tc.service.impl;

import by.epam.tc.dao.DAOFactory;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.dao.impl.DataBaseDAO;
import by.epam.tc.service.AddProductService;
import by.epam.tc.service.exception.ServiceException;

public class AddProduct implements AddProductService {

    @Override
    public void add(String categoryName, String name, String cost, String number) throws ServiceException {
        // проверка входных данных
        // ну и где проверка входных данных?
        DAOFactory daoFactory = DAOFactory.getInstance();
        DataBaseDAO dataBaseDAO = daoFactory.getDataBaseDAO();
        try {
            dataBaseDAO.addProduct(categoryName, name, cost, number);
        } catch (DAOException e) {
            throw new ServiceException();// почему исключение потерял? зачем ты так с DAOException
        }

    }

}
