package com.oopBackend.oopBackend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vendor")  // Specify collection name for MongoDB
public class Vendor implements Runnable {

    @Id
    private String id;  // MongoDB document ID
    private String name;  // Vendor name
    private final TicketPool ticketPool;
    private final int ticketReleaseRate;

    public Vendor(String id, String name, TicketPool ticketPool, int ticketReleaseRate) {
        this.id = id;
        this.name = name;
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!ticketPool.isFull()) {
                    ticketPool.addTickets(ticketReleaseRate);
                    System.out.println("Vendor " + name + " added " + ticketReleaseRate + " tickets.");
                    // Save vendor action to MongoDB
                    saveVendorAction();
                    Thread.sleep(1000);  // Add tickets every second
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Save vendor actions to MongoDB
    private void saveVendorAction() {
        // Here you would save the vendor's ticket adding actions, but this requires a repository
        // to persist this data, which we'll handle in the VendorRepository.
        System.out.println("Vendor action saved: " + name + " added " + ticketReleaseRate + " tickets.");
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

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;

    }
}
