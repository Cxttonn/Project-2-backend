//package se331.project2backend;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataLoader1 {
//
//    @Autowired
//    private EventRepository1 eventRepository;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String baseUrl = "https://my-json-server.typicode.com/Jasmxnej/";
//
//    @Bean
//    CommandLineRunner loadData() {
//        return args -> {
//            if (eventRepository.count() > 0) {
//                System.out.println("Data already exists in the 'events' table.");
//                return;
//            }
//
//            String[] parts = {
//                    "countrymedal/data1", "data2/data2", "data3/data3", "data4/data4",
//                    "data5/data5", "data6/data6", "data7/data7", "data8/data8",
//                    "data9/data9", "data10/data10"
//            };
//
//            List<Event2> allEvents = new ArrayList<>();
//
//            for (String part : parts) {
//                Event2[] events = restTemplate.getForObject(baseUrl + part, Event2[].class);
//                if (events != null) {
//                    for (Event2 event : events) {
//                        if (event.getId() == null || event.getId().isEmpty()) {
//                            throw new RuntimeException("Event ID is missing for some records.");
//                        }
//
//                        // Create and set the medals_by_sport
//                        Event2.MedalsBySport medalsBySport = new Event2.MedalsBySport();
//
//                        // Create totals for gold, silver, bronze
//                        Event2.MedalTotals totals = new Event2.MedalTotals();
//                        totals.setGold(getGoldMedals(event));   // Logic to get gold medals
//                        totals.setSilver(getSilverMedals(event)); // Logic to get silver medals
//                        totals.setBronze(getBronzeMedals(event)); // Logic to get bronze medals
//
//                        // Create the until_2024 object
//                        Event2.Until2024 until2024 = new Event2.Until2024();
//                        until2024.setTotal(totals);
//
//                        // Set the medals_by_sport structure
//                        medalsBySport.setUntil2024(until2024);
//                        event.setMedalsBySport(medalsBySport);
//
//                        allEvents.add(event);
//                    }
//                }
//            }
//
//            eventRepository.saveAll(allEvents);
//            System.out.println("Data successfully loaded into the 'events' table.");
//        };
//    }
//
//    // Implement these methods to extract the respective medal counts from the event
//    private int getGoldMedals(Event2 event) {
//        return (event.getMedalsBySport() != null && event.getMedalsBySport().getTotal() != null) ?
//                event.getMedalsBySport().getTotal().getGold() : 0;
//    }
//
//    private int getSilverMedals(Event2 event) {
//        return (event.getMedalsBySport() != null && event.getMedalsBySport().getTotal() != null) ?
//                event.getMedalsBySport().getTotal().getSilver() : 0;
//    }
//
//    private int getBronzeMedals(Event2 event) {
//        return (event.getMedalsBySport() != null && event.getMedalsBySport().getTotal() != null) ?
//                event.getMedalsBySport().getTotal().getBronze() : 0;
//    }
//}
