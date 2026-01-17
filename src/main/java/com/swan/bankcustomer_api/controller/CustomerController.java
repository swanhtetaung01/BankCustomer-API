package com.swan.bankcustomer_api.controller;

import com.swan.bankcustomer_api.model.Customer;
import com.swan.bankcustomer_api.repository.CustomerRepository;
import com.swan.bankcustomer_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAllCustomer() {

        return customerService.getAllCustomers();
    }
}
