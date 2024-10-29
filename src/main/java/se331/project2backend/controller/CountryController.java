package se331.project2backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se331.project2backend.entity.Country;
import se331.project2backend.entity.Event;
import se331.project2backend.service.CountryService;
import se331.project2backend.service.SportService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private SportService sportService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable String id) {
        return countryService.getCountries(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add-with-events")
    public ResponseEntity<Country> addCountryWithEvents(@RequestBody Country country) {
        Country savedCountry = countryService.addCountryWithEvents(country);
        return ResponseEntity.ok(savedCountry);
    }


    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PutMapping("/{id}")
//    public ResponseEntity<Country> updateCountry(@PathVariable String id, @RequestBody Country countryDetails) {
//        // Find the existing country by ID
//        Country existingCountry = countryService.getCountries(id);
//        if (existingCountry == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        existingCountry.setName(countryDetails.getName());
//        existingCountry.setDescription(countryDetails.getDescription());
//        existingCountry.setHostCountry(countryDetails.getHostCountry());
//        existingCountry.setFlagUrl(countryDetails.getFlagUrl());
//        existingCountry.setEvents(countryDetails.getEvents());
//
//        Country updatedCountry = countryService.addCountryWithEvents(existingCountry);
//        return ResponseEntity.ok(updatedCountry);
//    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable String id, @RequestBody Country countryDetails) {

        Country existingCountry = countryService.getCountries(id);
        if (existingCountry == null) {
            return ResponseEntity.notFound().build();
        }


        existingCountry.setName(countryDetails.getName());
        existingCountry.setDescription(countryDetails.getDescription());
        existingCountry.setHostCountry(countryDetails.getHostCountry());
        existingCountry.setFlagUrl(countryDetails.getFlagUrl());


        for (Event updatedEvent : countryDetails.getEvents()) {
            Optional<Event> existingEventOpt = existingCountry.getEvents().stream()
                    .filter(event -> event.getId().equals(updatedEvent.getId()))
                    .findFirst();

            if (existingEventOpt.isPresent()) {
                Event existingEvent = existingEventOpt.get();
                existingEvent.setName(updatedEvent.getName());
                existingEvent.setFlagUrl(updatedEvent.getFlagUrl());


                for (Event.Sport updatedSport : updatedEvent.getMedalsBySport().getUntil2024().getSports()) {
                    Optional<Event.Sport> existingSportOpt = existingEvent.getMedalsBySport().getUntil2024().getSports().stream()
                            .filter(sport -> sport.getName().equals(updatedSport.getName()))
                            .findFirst();

                    if (existingSportOpt.isPresent()) {

                        Event.Sport existingSport = existingSportOpt.get();
                        existingSport.setGold(updatedSport.getGold());
                        existingSport.setSilver(updatedSport.getSilver());
                        existingSport.setBronze(updatedSport.getBronze());
                    } else {

                        existingEvent.getMedalsBySport().getUntil2024().getSports().add(updatedSport);
                    }
                }
            } else {

                existingCountry.getEvents().add(updatedEvent);
            }
        }


        Country updatedCountry = countryService.addCountryWithEvents(existingCountry);
        return ResponseEntity.ok(updatedCountry);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String id) {
        boolean deleted = countryService.deleteCountryById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


