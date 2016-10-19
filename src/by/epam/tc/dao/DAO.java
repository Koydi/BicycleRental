package by.epam.tc.dao;

import by.epam.tc.bean.entity.Product;
import by.epam.tc.bean.entity.ReportCategoryResult;
import by.epam.tc.dao.exception.DAOException;

import java.sql.ResultSet;

public interface DAO {
    Product findProduct(String categoryName, String productName) throws DAOException;
    ResultSet reportCategoryNumber() throws DAOException;
    ResultSet reportCategoryMaxCost() throws DAOException;
    ResultSet reportCategoryMinCost() throws DAOException;
    void addProduct(String categoryName, String productName, String cost, String number) throws DAOException;
    void deleteProduct(String categoryName, String productName) throws DAOException;
    void editProduct(String oldName, String oldCategoryName, String newCategoryName,
                     String newName, String newCost, String newNumber) throws DAOException;
}
