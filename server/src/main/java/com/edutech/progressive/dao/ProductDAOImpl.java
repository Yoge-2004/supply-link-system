package com.edutech.progressive.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Product;

public class ProductDAOImpl implements ProductDAO {
    @Override 
    public int addProduct(Product product) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();

        String queryString = "INSERT INTO product (warehouse_id, product_name, product_description, quantity, price) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setInt(1, product.getWarehouseId());
        pStatement.setString(2, product.getProductName());
        pStatement.setString(3, product.getProductDescription());
        pStatement.setInt(4, product.getQuantity());
        pStatement.setDouble(5, product.getPrice());

        return pStatement.executeUpdate();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "SELECT * FROM product WHERE product_id=" + productId;

        Statement stmt = connection.createStatement();
        
        ResultSet rs = stmt.executeQuery(queryString);

        Product product = null;

        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt(1));
            product.setWarehouseId(rs.getInt(2));
            product.setProductName(rs.getString(3));
            product.setProductDescription(rs.getString(4));
            product.setQuantity(rs.getInt(5));
            product.setPrice(rs.getLong(6));
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        return;
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        return;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return new ArrayList<>();
    }
}
