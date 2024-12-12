package com.oopBackend.oopBackend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Represent MongoDB collection named 'Vendor'
@Document(collection = "Vendor")
public class Vendor implements Runnable {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String businessName;

    private TicketPool ticketPool;
    private int ticketReleaseRate;

    public Vendor() {
        // No-argument constructor for MongoDB
        this.ticketPool = null;
        this.ticketReleaseRate = 0;
    }

    // Constructor
    public Vendor(String name, String email, String password, String phone, String businessName, TicketPool ticketPool, int ticketReleaseRate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.businessName = businessName;
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    // Loop until thread is interrupted
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (!ticketPool.isFull()) {
                    ticketPool.addTickets(ticketReleaseRate);
                    System.out.println("Vendor " + name + " added " + ticketReleaseRate + " tickets.");
                    saveVendorAction();  // Log vendor action
                    Thread.sleep(1000);  // Simulate delay
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Vendor " + name + " thread interrupted.");
        }
    }

    // Save vendor actions to MongoDB
    private void saveVendorAction() {
        System.out.println("Vendor action saved: " + name + " added " + ticketReleaseRate + " tickets.");
    }

    // Getters and Setters
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }
}
