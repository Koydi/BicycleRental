package by.epam.tc.dao;

import by.epam.tc.dao.impl.DataBaseDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private DataBaseDAO dataBaseDAO = new DataBaseDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    public DataBaseDAO getDataBaseDAO() {
        return dataBaseDAO;
    }
}
