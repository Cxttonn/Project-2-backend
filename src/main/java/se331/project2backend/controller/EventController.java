package se331.project2backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import se331.project2backend.entity.Event;
import se331.project2backend.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/events/search/{keyword}")
    public Page<Event> searchByKeyword(
            @PathVariable String keyword,
            @RequestParam int page,
            @RequestParam int size) {
        return eventService.getByName(keyword, PageRequest.of(page - 1, size));
    }
}


