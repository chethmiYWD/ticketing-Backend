package com.oopBackend.oopBackend.Repository;

import com.oopBackend.oopBackend.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Extend MongoRepository for Event documents
@Repository
public interface EventRepository extends MongoRepository<Event, String> {

}
