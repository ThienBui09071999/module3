package com.example.product_manage_mvc.repository;

import com.example.product_manage_mvc.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean delete(String name);
    boolean update(Product product);
}
