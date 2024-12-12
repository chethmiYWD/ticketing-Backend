package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

// Extends MongoRepository for Vendor documents
public interface VendorRepository extends MongoRepository<Vendor, String> {

    // Find vendors by email and password
    Optional<Vendor> findByEmailAndPassword(String email, String password);

    // Find vendors by email
    Optional<Vendor> findByEmail(String email);
}
