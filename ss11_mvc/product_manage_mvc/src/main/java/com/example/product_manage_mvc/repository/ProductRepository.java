package com.example.product_manage_mvc.repository;

import com.example.product_manage_mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static final List<Product> productsList = new ArrayList<>();
    static {
        productsList.add(new Product("Iphone",100000,10));
        productsList.add(new Product("Laptop",120000,10));
        productsList.add(new Product("PC",130000,10));
        productsList.add(new Product("SmartPhone",150000,10));
    }

    @Override
    public List<Product> findAll() {
        return productsList;
    }

    @Override
    public boolean add(Product product) {
        productsList.add(product);
        return false;
    }

    @Override
    public boolean delete(String name) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getName().equals(name)) {
                productsList.remove(i);
                return false;
            }
        }
        return true;
    }
    public Product findProduct(String name){
        Product product=new Product();
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getName().equals(name)) {
                product=productsList.get(i);
            }
        }
        return product;
    }
    public boolean checkExistProduct(String name) {
        for (Product product : productsList) {
            if (product.getName().equals(name)) {
                product.getName();
                return true;

            }
        }
        return false;
    }
    @Override
    public boolean update(Product product) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getName().equals(product.getName())) {
                productsList.get(i).setName(product.getName());
                productsList.get(i).setPrice(product.getPrice());
                productsList.get(i).setQuantity(product.getQuantity());
                return false;
            }
        }
        return true;
    }
}
