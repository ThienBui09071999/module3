package com.example.product_manage_mvc.service;

import com.example.product_manage_mvc.model.Product;
import com.example.product_manage_mvc.repository.IProductRepository;
import com.example.product_manage_mvc.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean delete(String name) {
        if(productRepository.checkExistProduct(name)){
            productRepository.delete(name);
            return true;
        }
        return false;
    }


    @Override
    public Product findProduct(String name) {
        return productRepository.findProduct(name);
    }

    @Override
    public boolean update(Product product) {
        productRepository.update(product);
        return true;
    }
}
