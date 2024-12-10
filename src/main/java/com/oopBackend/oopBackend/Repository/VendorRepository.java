package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Optional<Vendor> findByEmail(String email); // Find Vendor by email
}
