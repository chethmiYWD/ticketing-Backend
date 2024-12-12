package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

// Extend MongoRepository for Customer documents
public interface CustomerRepository extends MongoRepository<Customer, String> {

    // Check if customer exists by email
    boolean existsByEmail(String email);

    // Method to find by email
    Optional<Customer> findByEmail(String email);

    // Custom login method
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
