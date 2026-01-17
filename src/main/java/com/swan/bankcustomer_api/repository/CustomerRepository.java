package com.swan.bankcustomer_api.repository;

import com.swan.bankcustomer_api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
