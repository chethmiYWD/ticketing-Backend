package com.oopBackend.oopBackend.Service;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {

    // Final instance of customer repository interface
    private final CustomerRepository customerRepository;

    // Constructor
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Method to register a new customer
    public void registerCustomer(Customer customer) {

        // Check if customer already exists by email
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Customer already exists with this email.");
        }
        System.out.println("Customer details before save: " + customer);
        // Save the new customer
        customerRepository.save(customer);
    }

    // Attempts to log in a customer
    public boolean loginCustomer(String email, String password) {
        // Find customer by email
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);

        // Check if the customer exists and the password matches
        return customerOptional.isPresent() && customerOptional.get().getPassword().equals(password);
    }

    // Retrieves customer by email address if exists
    public Customer getCustomerByEmailIfExists(String email) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        return customerOptional.orElse(null);  // Return customer or null
    }

}
