package by.epam.tc.dao.impl;

import by.epam.tc.bean.entity.Product;
import by.epam.tc.dao.DAO;
import by.epam.tc.dao.exception.DAOException;

import java.sql.*;


// ну вот, код надо было написать самим - и понеслось
public class DataBaseDAO implements DAO{
    // а где пул соединений?

    private Connection connection;// объект этого класса используется в единственном экземпляре, тогда при многопоточном
    // доступе твои клиенты что, будут делить один connection на всех?

    public DataBaseDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycles?useSSL=false", "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();// ну не создалось соединение, ну и фиг с ним, тихонько погасим и будет надеяться на светлое будущее
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProduct(String categoryName, String productName, String cost, String number) throws DAOException {
        Statement statement;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO product(name, id_category, cost, number) VALUES(");// неименованная константная строка
            stringBuilder.append("\"" + productName + "\",");
            String categoryId = getCategoryId(categoryName);
            stringBuilder.append(categoryId + ",");
            stringBuilder.append(cost + ",");
            stringBuilder.append(number + ");");

            statement = connection.createStatement();// а PreparedStatement тебе религия использовать не велит?
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {
            throw new DAOException();// опять исключение потерял
        }
    }


    @Override
    public ResultSet reportCategoryMaxCost() throws DAOException {
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name, (SELECT MAX(cost) FROM product WHERE product.id_category=category.id_category) FROM category");
        } catch (SQLException e) {
            throw new DAOException();
        }
        return resultSet;
    }

    @Override
    public ResultSet reportCategoryMinCost() throws DAOException {
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name, (SELECT MIN(cost) FROM product WHERE product.id_category=category.id_category) FROM category");
        } catch (SQLException e) {
            throw new DAOException();
        }
        return resultSet;
    }

    @Override
    public ResultSet reportCategoryNumber() throws DAOException {
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name, (SELECT SUM(number) FROM product WHERE product.id_category=category.id_category) FROM category");
        } catch (SQLException e) {
            throw new DAOException();
        }
        return resultSet;
    }

    @Override
    public void deleteProduct(String categoryName, String productName) throws DAOException {
        Statement statement;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String productId = getProductId(categoryName, productName);
            stringBuilder.append("DELETE FROM product WHERE id_product=" + productId);
            statement = connection.createStatement();
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    @Override
    public Product findProduct(String categoryName, String productName) throws DAOException {
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT");
        } catch (SQLException e) {
            throw new DAOException();
        }
        return null;
    }

    @Override
    public void editProduct(String oldName, String oldCategoryName, String newCategoryName,
                            String newName, String newCost, String newNumber) throws DAOException {
        Statement statement;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE product SET ");
            stringBuilder.append("name='" + newName + "', ");
            String categoryId = getCategoryId(newCategoryName);
            stringBuilder.append("id_category=" + categoryId + ", ");
            stringBuilder.append("cost=" + newCost + ", ");
            String productId = getProductId(oldCategoryName, oldName);
            stringBuilder.append("number=" + newNumber + " WHERE id_product=" + productId);
            statement = connection.createStatement();
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {
            throw new DAOException();
        }

    }

    private String getCategoryId(String categoryName) throws SQLException {
        Statement statement;
        String result = null;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id_category FROM category WHERE name='"
                                                    + categoryName + "'");
        while (resultSet.next()) {
            int temp = resultSet.getByte(1);
            result = Integer.toString(temp);
        }

        return result;
    }

    private String getProductId(String categoryName, String productName) throws SQLException {
        Statement statement;
        String result = null;
        String categoryId = getCategoryId(categoryName);
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id_product FROM product WHERE name='"
                                                    + productName + "' AND id_category=" + categoryId);
        while (resultSet.next()) {
            int temp = resultSet.getInt(1);
            result = Integer.toString(temp);
        }
        return result;
    }
}
