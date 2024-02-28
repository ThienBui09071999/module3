package com.example.thuchanh.service;

import com.example.thuchanh.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
    List<Customer> searchByName(String name);
}
