package se331.project2backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService1 {

    @Autowired
    private EventRepository1 eventRepository;

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

    public List<Event2> getAllEvents() {
        List<Event2> events = new ArrayList<>();
        for (String url : SOURCES) {
            Event2[] eventsFromSource = restTemplate.getForObject(url, Event2[].class);
            if (eventsFromSource != null) {
                for (Event2 event : eventsFromSource) {

                    if (event.getMedalsBySport() != null && event.getMedalsBySport().getUntil2024() != null) {
                        Event2.MedalTotals totals = event.getMedalsBySport().getUntil2024().getTotal();
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
        List<Event2> events = getAllEvents();


        System.out.println("Saving the following events to the database:");
        for (Event2 event : events) {
            System.out.println(event.getId() + ": " + event.getName() + " | Gold: " + event.getGoldMedals() + " | Silver: " + event.getSilverMedals() + " | Bronze: " + event.getBronzeMedals());
        }

        eventRepository.saveAll(events);
    }

    @PostConstruct
    public void init() {
        saveAllEvents();
    }

    public Event2 getEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }
}
