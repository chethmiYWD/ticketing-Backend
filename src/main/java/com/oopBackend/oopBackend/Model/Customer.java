package com.oopBackend.oopBackend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")  // Specify collection name
public class Customer implements Runnable {

    @Id
    private String id;  // MongoDB document ID
    private String name;
    private String email;
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;

    public Customer(String name, String email, TicketPool ticketPool, int customerRetrievalRate) {
        this.name = name;
        this.email = email;
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!ticketPool.isEmpty()) {
                    ticketPool.removeTicket();
                    System.out.println("Customer " + name + " retrieved 1 ticket.");
                    // Optionally, you can save the customer’s ticket retrieval status in MongoDB here
                    Thread.sleep(1000);  // Retrieve tickets every second
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Getters and setters for MongoDB document
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
}
