package com.swan.bankcustomer_api.service;

import com.swan.bankcustomer_api.model.Customer;
import com.swan.bankcustomer_api.repository.CustomerRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Account created successfully";
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
