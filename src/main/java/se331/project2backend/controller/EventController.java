package se331.project2backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
        return eventService.fetchAllEventsFromDB();
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

//    @PostMapping("/update-sports")
//    public ResponseEntity<String> updateSports(@RequestBody Event event) {
////        System.out.println("Received payload: " + event);
//        try {
//            eventService.updateEvent(event); // Call the service to handle the update
//            return ResponseEntity.ok("Sports updated successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Failed to update sports: " + e.getMessage());
//        }
//    }


    @PostMapping("/update-sports")
    public ResponseEntity<String> updateSports(@RequestBody Event event) {
        try {
            eventService.updateEvent(event);
            return ResponseEntity.ok("Sports and Event totals updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to update sports and totals: " + e.getMessage());
        }
    }
}



