package se331.project2backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se331.project2backend.repository.EventRepository;
import se331.project2backend.entity.Event;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    public Page<Event> getByName(String name, Pageable pageable) {
        return eventRepository.findByNameContaining(name, pageable);    }
    private static final String[] SOURCES = {
            "https://my-json-server.typicode.com/Jasmxnej/countrymedal/data1",
            "https://my-json-server.typicode.com/Jasmxnej/data2/data2",
            "https://my-json-server.typicode.com/Jasmxnej/data3/data3",
            "https://my-json-server.typicode.com/Jasmxnej/data4/data4",
            "https://my-json-server.typicode.com/Jasmxnej/data5/data5",
            "https://my-json-server.typicode.com/Jasmxnej/data6/data6",
            "https://my-json-server.typicode.com/Jasmxnej/data7/data7",
            "https://my-json-server.typicode.com/Jasmxnej/data8/data8",
            "https://my-json-server.typicode.com/Jasmxnej/data9/data9",
            "https://my-json-server.typicode.com/Jasmxnej/data10/data10"
    };

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        for (String url : SOURCES) {
            Event[] eventsFromSource = restTemplate.getForObject(url, Event[].class);
            if (eventsFromSource != null) {
                for (Event event : eventsFromSource) {

                    if (event.getMedalsBySport() != null && event.getMedalsBySport().getUntil2024() != null) {
                        Event.MedalTotals totals = event.getMedalsBySport().getUntil2024().getTotal();
                        if (totals != null) {
                            event.setGoldMedals(totals.getGold());
                            event.setSilverMedals(totals.getSilver());
                            event.setBronzeMedals(totals.getBronze());
                        }
                    }

                    event.setTotalMedals(event.getGoldMedals() + event.getSilverMedals() + event.getBronzeMedals());
                    events.add(event);
                }
            }
        }
        return events;
    }

    public void saveAllEvents() {
        List<Event> events = getAllEvents();


        System.out.println("Saving the following events to the database:");
        for (Event event : events) {
            System.out.println(event.getId() + ": " + event.getName() + " | Gold: " + event.getGoldMedals() + " | Silver: " + event.getSilverMedals() + " | Bronze: " + event.getBronzeMedals());
        }

        eventRepository.saveAll(events);
    }

    @PostConstruct
    public void init() {
        saveAllEvents();
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event updateEvent(Event event) {return eventRepository.save(event);}

}



