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

        PreparedStatement pStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
        pStatement.setInt(1, product.getWarehouseId());
        pStatement.setString(2, product.getProductName());
        pStatement.setString(3, product.getProductDescription());
        pStatement.setInt(4, product.getQuantity());
        pStatement.setDouble(5, product.getPrice());

        pStatement.executeUpdate();
        ResultSet rs = pStatement.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            product.setProductId(generatedId);
            return generatedId;
        }
        return -1;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "SELECT * FROM product WHERE product_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setInt(1, productId);
        
        ResultSet rs = pStatement.executeQuery();

        Product product = null;

        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setWarehouseId(rs.getInt("warehouse_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductDescription(rs.getString("product_description"));
            product.setQuantity(rs.getInt("quantity"));
            product.setPrice(rs.getLong("price"));
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "UPDATE product SET warehouse_id = ?, product_name = ?, product_description = ?, quantity = ?, price = ? WHERE product_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setInt(1, product.getWarehouseId());
        pStatement.setString(2, product.getProductName());
        pStatement.setString(3, product.getProductDescription());
        pStatement.setInt(4, product.getQuantity());
        pStatement.setDouble(5, product.getPrice());
        pStatement.setInt(6, product.getProductId());

        pStatement.executeUpdate();
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "DELETE FROM product WHERE product_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setInt(1, productId);

        pStatement.executeUpdate();
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "SELECT * FROM product";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);

        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setWarehouseId(rs.getInt("warehouse_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductDescription(rs.getString("product_description"));
            product.setQuantity(rs.getInt("quantity"));
            product.setPrice(rs.getLong("price"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getAllProductByWarehouse(int warehouseId) {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionManager.getConnection();
            String queryString = "SELECT * FROM product WHERE warehouse_id = ?";

            PreparedStatement pStatement = connection.prepareStatement(queryString);
            pStatement.setInt(1, warehouseId);

            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setWarehouseId(rs.getInt("warehouse_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductDescription(rs.getString("product_description"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getLong("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
