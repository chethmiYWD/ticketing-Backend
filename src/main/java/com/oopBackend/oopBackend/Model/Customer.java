package com.oopBackend.oopBackend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Represents a MongoDB collection named 'Customer'
@Document(collection = "Customer")
public class Customer {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String contactNumber;

    // Constructor
    public Customer(String name, String email, String password, String contactNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
