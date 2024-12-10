package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);  // Method to find customer by email
}
