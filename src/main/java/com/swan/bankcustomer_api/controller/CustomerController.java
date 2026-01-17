package com.swan.bankcustomer_api.controller;

import com.swan.bankcustomer_api.model.Customer;
import com.swan.bankcustomer_api.repository.CustomerRepository;
import com.swan.bankcustomer_api.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        try{
            String status = customerService.createCustomer(customer);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch(ResponseStatusException e) {
            throw e;
        }
    }
}
