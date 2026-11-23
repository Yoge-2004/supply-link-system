package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.service.ProductService;

public class ProductServiceImplJdbc implements ProductService {

  private ProductDAO productDAO;

  public ProductServiceImplJdbc(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

    @Override
    public int addProduct(Product product) throws SQLException {
       return -1;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
      return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return new ArrayList<>();
    }

}