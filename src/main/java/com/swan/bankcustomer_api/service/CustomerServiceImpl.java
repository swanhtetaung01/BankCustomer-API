package com.swan.bankcustomer_api.service;

import com.swan.bankcustomer_api.model.Customer;
import com.swan.bankcustomer_api.repository.CustomerRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.apache.coyote.Response;
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
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @Override
    public String updateCustomer(Long customerId, Customer customer) {
        Customer targetCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer does not exist"));
        targetCustomer.setFirstName(customer.getFirstName());
        customerRepository.save(targetCustomer);
        return "Customer is successfully updated";
    }

    @Override
    public String deleteCustomer(Long customerId) {
        Customer targetCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer does not exist"));
        customerRepository.delete(targetCustomer);
        return "Customer is deleted successfully";
    }

//    private void applyUpdates()

}
