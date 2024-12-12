package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//Handle '/customer' requests
@RestController
@RequestMapping("/customers")
public class CustomerController {

//Inject customer service implementation
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Handle POST requests to /register endpoint
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerCustomer(@RequestBody Customer customer) {
        Map<String, String> response = new HashMap<>();

        // Register the customer
        try {
            customerService.registerCustomer(customer);
            response.put("message", "Customer registered successfully!");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
            response.put("message", "Registration failed. Please try again.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

