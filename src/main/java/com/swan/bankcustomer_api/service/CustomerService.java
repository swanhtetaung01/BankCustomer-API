package com.swan.bankcustomer_api.service;

import com.swan.bankcustomer_api.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    public String createCustomer();

    public List<Customer> getAllCustomers();

    public Customer getCustomerById();

    public String updateCustomer();

    public String deleteCustomer();
}
