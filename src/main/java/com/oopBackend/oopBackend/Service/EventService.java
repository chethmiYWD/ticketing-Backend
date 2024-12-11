package com.oopBackend.oopBackend.Service;

import com.oopBackend.oopBackend.Model.Event;
import com.oopBackend.oopBackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Method to create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);  // Save event to the database
    }

    // Method to get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();  // Fetch all events
    }
}
