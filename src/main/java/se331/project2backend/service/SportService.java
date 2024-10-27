package se331.project2backend.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.project2backend.entity.Event;
import se331.project2backend.repository.EventRepository;
import se331.project2backend.repository.SportRepository;

@Service
public class SportService {

    @Autowired
    private EventRepository eventRepository; // Assume you have a repository for database operations


    @Transactional
    public void updateEventMedals(Event event) {
        Event existingEvent = eventRepository.findById(event.getId()).orElseThrow(() ->new IllegalArgumentException("Event not Found"));


        existingEvent.setMedalsBySport(event.getMedalsBySport());

        eventRepository.save(existingEvent);
    }
}