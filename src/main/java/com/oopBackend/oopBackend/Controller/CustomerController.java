package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Register customer
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully!");
    }

    // Login customer
    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer loginDetails) {
        boolean isLoggedIn = customerService.loginCustomer(loginDetails.getEmail(), loginDetails.getPassword());

        if (isLoggedIn) {
            return ResponseEntity.ok("Login successful!");
        }

        return ResponseEntity.status(401).body("Invalid credentials.");
    }
}
