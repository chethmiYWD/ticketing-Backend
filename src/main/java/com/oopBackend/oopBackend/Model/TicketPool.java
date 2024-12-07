package com.oopBackend.oopBackend.Model;

import java.util.concurrent.ArrayBlockingQueue;

public class TicketPool {

    private ArrayBlockingQueue<String> ticketQueue;
    private int maxCapacity;

    // Constructor to initialize the ticket pool with the specified max capacity
    public TicketPool(int initialCapacity) {
        this.ticketQueue = new ArrayBlockingQueue<>(initialCapacity);
        this.maxCapacity = initialCapacity;  // Set max capacity on initialization
    }

    // Method to add tickets to the pool (make sure not to exceed max capacity)
    public void addTickets(int ticketReleaseRate) {
        for (int i = 0; i < ticketReleaseRate; i++) {
            if (ticketQueue.size() < maxCapacity) {
                ticketQueue.add("Ticket " + (ticketQueue.size() + 1));
            }
        }
    }

    // Method to remove a ticket from the pool
    public void removeTicket() {
        if (!ticketQueue.isEmpty()) {
            ticketQueue.poll();
        }
    }

    // Method to check if the pool is empty
    public boolean isEmpty() {
        return ticketQueue.isEmpty();
    }

    // Method to check if the pool is full
    public boolean isFull() {
        return ticketQueue.size() == maxCapacity;
    }

    // Method to get the current number of tickets in the pool
    public int getCurrentTickets() {
        return ticketQueue.size();
    }

    // Method to set the maximum capacity
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    // Method to get the maximum capacity
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ArrayBlockingQueue<String> getTicketQueue() {
        return ticketQueue;
    }
}
