package com.example.product_manage_mvc.service;

import com.example.product_manage_mvc.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product product);
    boolean delete(String name);
    Product findProduct(String name);
    boolean update(Product product);
}
