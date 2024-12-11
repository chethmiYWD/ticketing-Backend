//package com.oopBackend.oopBackend.Repository;
//
//import com.oopBackend.oopBackend.Model.Customer;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.Optional;
//
//public interface CustomerRepository extends MongoRepository<Customer, String> {
//    Optional<Customer> findByEmail(String email);  // Method to find customer by email
//}

package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    // Check if customer exists by email
    boolean existsByEmail(String email);

    // Optionally, you can also use a method for finding by email
    Optional<Customer> findByEmail(String email);

    // Custom login method
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
