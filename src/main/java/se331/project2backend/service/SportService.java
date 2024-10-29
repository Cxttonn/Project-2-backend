package se331.project2backend.service;
//
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import se331.project2backend.entity.Event;
//import se331.project2backend.repository.EventRepository;
//import se331.project2backend.repository.SportRepository;
//
//@Service
//public class SportService {
//
//    @Autowired
//    private EventRepository eventRepository; // Assume you have a repository for database operations
//
//
//    @Transactional
//    public void updateEventMedals(Event event) {
//        Event existingEvent = eventRepository.findById(event.getId()).orElseThrow(() ->new IllegalArgumentException("Event not Found"));
//
//        existingEvent.setMedalsBySport(event.getMedalsBySport());
//
//        eventRepository.save(existingEvent);
//    }
//}


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.project2backend.entity.Event;
import se331.project2backend.repository.EventRepository;
import se331.project2backend.repository.SportRepository;

@Service
public class SportService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public void updateEventMedals(Event event) {
        Event existingEvent = eventRepository.findById(event.getId()).orElseThrow(() -> new IllegalArgumentException("Event not found"));

        // Update sports details
        existingEvent.setMedalsBySport(event.getMedalsBySport());

        // Recalculate and update total medals
        updateEventMedalTotals(existingEvent);

        eventRepository.save(existingEvent);
    }

    private void updateEventMedalTotals(Event event) {
        int totalGold = event.getMedalsBySport().getUntil2024().getSports().stream()
                .mapToInt(sport -> sport.getGold())
                .sum();
        int totalSilver = event.getMedalsBySport().getUntil2024().getSports().stream()
                .mapToInt(sport -> sport.getSilver())
                .sum();
        int totalBronze = event.getMedalsBySport().getUntil2024().getSports().stream()
                .mapToInt(sport -> sport.getBronze())
                .sum();


        event.setGoldMedals(totalGold);
        event.setSilverMedals(totalSilver);
        event.setBronzeMedals(totalBronze);
        event.setTotalMedals(totalGold + totalSilver + totalBronze);
    }
}