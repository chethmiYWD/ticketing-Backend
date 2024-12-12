package com.oopBackend.oopBackend.Controller;

import com.oopBackend.oopBackend.Repository.EventRepository;
import com.oopBackend.oopBackend.Model.Event;
import com.oopBackend.oopBackend.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") //Frontend URL
@RestController
//Handle '/events' requests
@RequestMapping("/events")
public class EventController {

    // Final instance of event service
    private final EventService eventService;

    // Final instance of event repository interface
    private final EventRepository eventRepository;

    // Constructor for EventController class
    @Autowired
    public EventController(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    // Endpoint to create a new event
    @PostMapping("/add")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        try {
            Event savedEvent = eventService.createEvent(event);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to fetch all events
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        try {
            List<Event> events = eventService.getAllEvents();
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to handle booking attempts
    @PutMapping("/{id}/bookTicket")
    public ResponseEntity<Event> bookTicket(@PathVariable String id) {
        Optional<Event> optionalEvent = eventRepository.findById(id); // Use the instance method
        if (!optionalEvent.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Check ticket availability, increment count if tickets are available and save updated event
        Event event = optionalEvent.get();
        if (event.getTicketsSold() < event.getMaxTickets()) {
            event.setTicketsSold(event.getTicketsSold() + 1);
            eventRepository.save(event); // Save updated event
            return ResponseEntity.ok(event);
        }

        // Error response if request invalid
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
