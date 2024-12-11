package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Model.Vendor;
import com.oopBackend.oopBackend.Repository.CustomerRepository;
import com.oopBackend.oopBackend.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginDetails) {
        String email = loginDetails.get("email");
        String password = loginDetails.get("password");

        // Check if the user is a customer
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);
        if (customer.isPresent()) {
            return ResponseEntity.ok(Map.of(
                    "email", email,
                    "role", "Customer"
            ));
        }

        // Check if the user is a vendor
        Optional<Vendor> vendor = vendorRepository.findByEmailAndPassword(email, password);
        if (vendor.isPresent()) {
            return ResponseEntity.ok(Map.of(
                    "email", email,
                    "role", "Vendor"
            ));
        }

        // If neither, return unauthorized
        return ResponseEntity.status(401).body(Map.of(
                "message", "Invalid email or password"
        ));
    }
}
