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

@CrossOrigin(origins = "http://localhost:4200") // Add the frontend's origin
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final EventRepository eventRepository;

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

    @PutMapping("/{id}/bookTicket")
    public ResponseEntity<Event> bookTicket(@PathVariable String id) {
        Optional<Event> optionalEvent = eventRepository.findById(id); // Use the instance method
        if (!optionalEvent.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Event event = optionalEvent.get();
        if (event.getTicketsSold() < event.getMaxTickets()) {
            event.setTicketsSold(event.getTicketsSold() + 1);
            eventRepository.save(event); // Save updated event
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
