package com.oopBackend.oopBackend.Model;

import java.util.concurrent.ArrayBlockingQueue;

public class TicketPool {

    // Thread-safe queue to store ticket-related data
    private final ArrayBlockingQueue<String> ticketQueue;
    private int maxCapacity;

    // Constructor to initialize the ticket pool with the specified max capacity
    public TicketPool(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0.");
        }
        this.ticketQueue = new ArrayBlockingQueue<>(initialCapacity);
        this.maxCapacity = initialCapacity;
    }

    // Method to add tickets to the pool
    public synchronized void addTickets(int ticketReleaseRate) {
        if (ticketReleaseRate <= 0) {
            System.out.println("Ticket release rate must be greater than 0.");
            return;
        }
        for (int i = 0; i < ticketReleaseRate; i++) {
            if (ticketQueue.size() < maxCapacity) {
                String ticket = "Ticket " + (ticketQueue.size() + 1);
                ticketQueue.add(ticket);
                System.out.println("Added: " + ticket);
            } else {
                System.out.println("Ticket pool is full. Cannot add more tickets.");
                break;
            }
        }
    }

    // Method to remove a ticket from the pool
    public synchronized String removeTicket() {
        if (!ticketQueue.isEmpty()) {
            String removedTicket = ticketQueue.poll();
            System.out.println("Removed: " + removedTicket);
            return removedTicket;
        } else {
            System.out.println("No tickets to remove. Pool is empty.");
            return null;
        }
    }

    // Method to check if the pool is empty
    public synchronized boolean isEmpty() {
        return ticketQueue.isEmpty();
    }

    // Method to check if the pool is full
    public synchronized boolean isFull() {
        return ticketQueue.size() == maxCapacity;
    }

    // Method to get the current number of tickets in the pool
    public synchronized int getCurrentTickets() {
        return ticketQueue.size();
    }

    // Method to set the maximum capacity
    public synchronized void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than 0.");
        }
        if (maxCapacity < ticketQueue.size()) {
            throw new IllegalStateException("New capacity cannot be less than the current ticket count.");
        }
        this.maxCapacity = maxCapacity;
        System.out.println("Max capacity updated to: " + maxCapacity);
    }

    // Method to get the maximum capacity
    public synchronized int getMaxCapacity() {
        return maxCapacity;
    }

    // Get the ticket queue
    public synchronized ArrayBlockingQueue<String> getTicketQueue() {
        ArrayBlockingQueue<String> copy = new ArrayBlockingQueue<>(maxCapacity);
        copy.addAll(ticketQueue); // Copy the elements
        return copy;
    }
}
