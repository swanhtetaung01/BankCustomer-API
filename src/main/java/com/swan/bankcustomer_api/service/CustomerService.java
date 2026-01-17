package com.swan.bankcustomer_api.service;

import com.swan.bankcustomer_api.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    public String createCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Long customerId);

    public String updateCustomer(Long customerId, Customer customer);

    public String deleteCustomer(Long customerId);
}
