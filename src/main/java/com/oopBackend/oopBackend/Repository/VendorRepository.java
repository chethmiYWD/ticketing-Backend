package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {
    // Custom query methods can be added here, if needed
    Vendor findByName(String name);  // Example method to find vendor by name
}
