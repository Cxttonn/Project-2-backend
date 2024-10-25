package se331.project2backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController1 {

    @Autowired
    private EventService1 eventService;

    @GetMapping("/events")
    public List<Event2> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public Event2 getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }
}