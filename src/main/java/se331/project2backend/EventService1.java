package se331.project2backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService1 {

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
                    events.add(event);
                }
            }
        }
        return events;
    }

    public Event2 getEventById(String id) {
        return getAllEvents().stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
