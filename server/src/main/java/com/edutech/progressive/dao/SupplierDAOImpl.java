package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "INSERT INTO supplier (supplier_name, email, username, password, phone, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pStatement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
        pStatement.setString(1, supplier.getSupplierName());
        pStatement.setString(2, supplier.getEmail());
        pStatement.setString(3, supplier.getUsername());
        pStatement.setString(4, supplier.getPassword());
        pStatement.setString(5, supplier.getPhone());
        pStatement.setString(6, supplier.getAddress());
        pStatement.setString(7, supplier.getRole());

        pStatement.executeUpdate();
        ResultSet rs = pStatement.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            supplier.setSupplierId(generatedId);
            return generatedId;
        }
        return -1;
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "SELECT * FROM supplier WHERE supplier_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setInt(1, supplierId);

        ResultSet rs = pStatement.executeQuery();
        if (rs.next()) {
            Supplier supplier = new Supplier();
            supplier.setSupplierId(rs.getInt("supplier_id"));
            supplier.setSupplierName(rs.getString("supplier_name"));
            supplier.setEmail(rs.getString("email"));
            supplier.setPhone(rs.getString("phone"));
            supplier.setAddress(rs.getString("address"));
            supplier.setUsername(rs.getString("username"));
            supplier.setPassword(rs.getString("password"));
            supplier.setRole(rs.getString("role"));
            return supplier;
        }
        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "UPDATE supplier SET supplier_name = ?, email = ?, username = ?, password = ?, phone = ?, address = ?, role = ? WHERE supplier_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setString(1, supplier.getSupplierName());
        pStatement.setString(2, supplier.getEmail());
        pStatement.setString(3, supplier.getUsername());
        pStatement.setString(4, supplier.getPassword());
        pStatement.setString(5, supplier.getPhone());
        pStatement.setString(6, supplier.getAddress());
        pStatement.setString(7, supplier.getRole());
        pStatement.setInt(8, supplier.getSupplierId());

        pStatement.executeUpdate();
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "DELETE FROM supplier WHERE supplier_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(queryString);
        pStatement.setInt(1, supplierId);

        pStatement.executeUpdate();
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String queryString = "SELECT * FROM supplier";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);

        List<Supplier> suppliers = new ArrayList<>();
        while (rs.next()) {
            Supplier supplier = new Supplier();
            supplier.setSupplierId(rs.getInt("supplier_id"));
            supplier.setSupplierName(rs.getString("supplier_name"));
            supplier.setEmail(rs.getString("email"));
            supplier.setPhone(rs.getString("phone"));
            supplier.setAddress(rs.getString("address"));
            supplier.setUsername(rs.getString("username"));
            supplier.setPassword(rs.getString("password"));
            supplier.setRole(rs.getString("role"));
            suppliers.add(supplier);
        }
        return suppliers;
    }
}
