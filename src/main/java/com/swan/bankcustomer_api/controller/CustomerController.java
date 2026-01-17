package com.swan.bankcustomer_api.controller;

import com.swan.bankcustomer_api.model.Customer;
import com.swan.bankcustomer_api.service.CustomerService;
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
        String status = customerService.createCustomer(customer);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer fetchedCustomer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(fetchedCustomer, HttpStatus.OK);
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        try{
            String status = customerService.updateCustomer(customerId, customer);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch(ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        try{
            String status = customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch(ResponseStatusException e) {
             return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
