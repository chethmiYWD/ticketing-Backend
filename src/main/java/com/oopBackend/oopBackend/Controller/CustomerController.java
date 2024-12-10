package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
        return ResponseEntity.ok("Customer saved successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        return ResponseEntity.of(customerRepo.findById(id));
    }
}
