package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    // Add custom query methods if needed
}