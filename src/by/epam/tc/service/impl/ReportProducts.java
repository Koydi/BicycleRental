package by.epam.tc.service.impl;

import by.epam.tc.bean.entity.ReportCategoryResult;
import by.epam.tc.dao.DAOFactory;
import by.epam.tc.dao.exception.DAOException;
import by.epam.tc.dao.impl.DataBaseDAO;
import by.epam.tc.service.ReportProductsService;
import by.epam.tc.service.exception.ServiceException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportProducts implements ReportProductsService {

    @Override
    public List<ReportCategoryResult> report() throws ServiceException {
        List<ReportCategoryResult> result = new ArrayList<>();
        // проверка входных данных
        DAOFactory daoFactory = DAOFactory.getInstance();
        DataBaseDAO dataBaseDAO = daoFactory.getDataBaseDAO();
        try {
            ResultSet resultSetNumber = dataBaseDAO.reportCategoryNumber();
            ResultSet resultSetMin = dataBaseDAO.reportCategoryMinCost();
            ResultSet resultSetMax = dataBaseDAO.reportCategoryMaxCost();
            while (resultSetMax.next() && resultSetMin.next() && resultSetNumber.next()) {
                ReportCategoryResult temp = new ReportCategoryResult();
                result.add(temp);
                temp.setMaxCost(resultSetMax.getInt(2));
                temp.setNumberProducts(resultSetNumber.getInt(2));
                temp.setMinCost(resultSetMin.getInt(2));
                temp.setCategoryName(resultSetMax.getString(1));
            }

        } catch (DAOException e) {
            throw new ServiceException();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
