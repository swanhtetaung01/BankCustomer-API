package com.swan.bankcustomer_api.service;

import com.swan.bankcustomer_api.model.Customer;
import com.swan.bankcustomer_api.repository.CustomerRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer() {
        return "";
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById() {
        return null;
    }

    @Override
    public String updateCustomer() {
        return "";
    }

    @Override
    public String deleteCustomer() {
        return "";
    }

}
