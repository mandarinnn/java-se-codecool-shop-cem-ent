package com.codecool.shop.dao.jdbc;

import com.codecool.shop.DbConnection;
import com.codecool.shop.controller.CartController;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryDaoJdbc.class);
    DbConnection dbConnection = new DbConnection();
    private static ProductCategoryDaoJdbc instance = null;


    private ProductCategoryDaoJdbc() {
    }

    public static ProductCategoryDaoJdbc getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoJdbc();
        }
        return instance;
    }



    @Override
    public void add(ProductCategory category) {
        String query = "INSERT INTO productcategories (name, department, description) VALUES(?, ?, ?)";
        String[] columnsToReturn = {"id"};

        // connection and preparedstatement are autoclosable, if instantiated in try

        try (Connection connection =  dbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query, columnsToReturn)) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDepartment());
            ps.setString(3, category.getDescription());

            ps.executeUpdate();

            // to get id of created row
            ResultSet generatedKeys = ps.getGeneratedKeys();
            generatedKeys.next();
            category.setId(generatedKeys.getInt("id"));
            logger.info("Category added {}", category.toString());
        }
        catch (IOException | SQLException ex) {
            logger.error("Error while connecting to database", ex);
        }
    }


    @Override
    public ProductCategory find(int id) {

        String query = "SELECT * FROM productcategories WHERE id=?;";

        try {
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            return (resultSet.next()) ? createProductCategory(resultSet) : null;
        } catch (SQLException | IOException e) {
            logger.error("Error while connecting to database", e);
        }
        return null;
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM productcategories WHERE id=?;";
        try {
            PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            logger.info("Category removed: {}", id);
        } catch (IOException | SQLException e) {
            logger.error("Error while connecting to database", e);
        }
    }

    @Override
    public List<ProductCategory> getAll() {
        LinkedList<ProductCategory> productCategoryList = new LinkedList<>();
        String query = "SELECT * FROM productcategories";

        try (PreparedStatement pstmt = dbConnection.getConnection().prepareStatement(query);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                productCategoryList.add(createProductCategory(resultSet));
            }
            return productCategoryList;
        } catch (SQLException | IOException e) {
            logger.error("Error while connecting to database", e);
        }
        return null;
    }

    private static ProductCategory createProductCategory(ResultSet resultSet) throws SQLException {
        return new ProductCategory(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("department"),
                resultSet.getString("description"));
    }
}
