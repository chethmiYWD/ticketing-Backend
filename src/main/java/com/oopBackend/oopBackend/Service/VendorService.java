//package com.oopBackend.oopBackend.Service;
//
//import com.oopBackend.oopBackend.Model.Vendor;
//import com.oopBackend.oopBackend.Repository.VendorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.oopBackend.oopBackend.Exception.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class VendorService {
//
//    private final VendorRepository vendorRepository;
//
//    @Autowired
//    public VendorService(VendorRepository vendorRepository) {
//        this.vendorRepository = vendorRepository;
//    }
//
//    public Vendor saveVendor(Vendor vendor) {
//        return vendorRepository.save(vendor);
//    }
//
//    public Optional<Vendor> getVendorById(String id) {
//        return vendorRepository.findById(id);
//    }
//
//    public List<Vendor> getAllVendors() {
//        return vendorRepository.findAll();
//    }
//
//    public Vendor updateVendor(String id, Vendor vendorDetails) {
//        Vendor vendor = vendorRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
//
//        vendor.setName(vendorDetails.getName());
//        vendor.setEmail(vendorDetails.getEmail());
//        vendor.setPhone(vendorDetails.getPhone());
//        vendor.setBusinessName(vendorDetails.getBusinessName());
//
//        return vendorRepository.save(vendor);
//    }
//
//    public void deleteVendor(String id) {
//        Vendor vendor = vendorRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
//        vendorRepository.delete(vendor);
//    }
//}

package com.oopBackend.oopBackend.Service;

import com.oopBackend.oopBackend.Model.Vendor;
import com.oopBackend.oopBackend.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService {

    // Final instance of VendorRepository interface
    private final VendorRepository vendorRepository;

    // Constructor
    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // Attempts to log in a vendor
    public Optional<Vendor> loginVendor(String email, String password) {
        return vendorRepository.findByEmailAndPassword(email, password);
    }

    // Attempts to find a vendor by an email
    public Optional<Vendor> findByEmail(String email) {
        return vendorRepository.findByEmail(email);
    }
}
