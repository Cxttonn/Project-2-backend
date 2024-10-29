package se331.project2backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import se331.project2backend.entity.Event;
import se331.project2backend.service.SportService;

@RestController
@RequestMapping("/api/v1")
public class SportController {
    @Autowired
    private SportService sportService;

//    public SportController(SportService sportsService) {
//        this.sportService = sportsService;
//    }

    @PostMapping("/update-sports")
    public ResponseEntity<String> updateSports(@RequestBody Event event) {
        try {
            sportService.updateEventMedals(event);
            return ResponseEntity.ok("Sports updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to update sports: " + e.getMessage());
        }
    }
}