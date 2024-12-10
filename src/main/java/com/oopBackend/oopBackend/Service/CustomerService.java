package com.oopBackend.oopBackend.Service;

import com.oopBackend.oopBackend.Model.Customer;
import com.oopBackend.oopBackend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    // Register a new customer
    public Customer registerCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    // Login customer by comparing email and password (without encryption)
    public boolean loginCustomer(String email, String password) {
        Optional<Customer> customer = customerRepo.findByEmail(email);

        // Check if the customer exists and if the passwords match
        return customer.isPresent() && customer.get().getPassword().equals(password);
    }

    // Get a customer by email (for login or other purposes)
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepo.findByEmail(email);
    }
}
