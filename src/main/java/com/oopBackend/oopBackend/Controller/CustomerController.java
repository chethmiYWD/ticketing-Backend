//package com.oopBackend.oopBackend.Controller;
//
//import com.oopBackend.oopBackend.Model.Customer;
//import com.oopBackend.oopBackend.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//
//    private final CustomerService customerService;
//
//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    // Register customer
//    @PostMapping("/register")
//    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
//        customerService.registerCustomer(customer);
//        return ResponseEntity.ok("Customer registered successfully!");
//    }
//
//    // Login customer
//    @PostMapping("/login")
//    public ResponseEntity<String> loginCustomer(@RequestBody Customer loginDetails) {
//        boolean isLoggedIn = customerService.loginCustomer(loginDetails.getEmail(), loginDetails.getPassword());
//
//        if (isLoggedIn) {
//            return ResponseEntity.ok("Login successful!");
//        }
//
//        return ResponseEntity.status(401).body("Invalid credentials.");
//    }
//}

package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Register customer
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerCustomer(@RequestBody Customer customer) {
        Map<String, String> response = new HashMap<>();

        try {
            // Register the customer
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

    // Login customer
//    @PostMapping("/login")
//    public ResponseEntity<UserResponse> loginCustomer(@RequestBody LoginRequest loginRequest) {
//        String email = loginRequest.getEmail();
//        String password = loginRequest.getPassword();
//
//        // Authenticate customer
//        Customer customer = customerService.authenticate(email, password);
//
//        if (customer != null) {
//            // Create a UserResponse with role 'Customer'
//            UserResponse response = new UserResponse(customer.getEmail(), "Customer");
//            return ResponseEntity.ok(response);
//        }
//
//        // If not a customer, check vendor login
//        Vendor vendor = vendorService.authenticate(email, password);
//
//        if (vendor != null) {
//            // Create a UserResponse with role 'Vendor'
//            UserResponse response = new UserResponse(vendor.getEmail(), "Vendor");
//            return ResponseEntity.ok(response);
//        }
//
//        // If authentication fails for both, return unauthorized
//        return ResponseEntity.status(401).body(null);
//    }
//}
