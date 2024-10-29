package se331.project2backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se331.project2backend.entity.Event;
import se331.project2backend.repository.CountryRepository;
import se331.project2backend.entity.Country;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    private final RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void init() {
        fetchAndSaveCountries();
    }

    public void fetchAndSaveCountries() {
        String[] parts = {
                "dbolympic",
                "dbolympic2",
                "dbolympic3",
                "dbolympic4",
                "dbolympic5",
                "dbolympic6",
                "dbolympic7",
                "dbolympic8",
                "dbolympic9"
        };

        List<Country> countries = new ArrayList<>();

        for (String part : parts) {
            try {
                Country[] countryData = restTemplate.getForObject(
                        "https://my-json-server.typicode.com/matchimaky/" + part + "/country",
                        Country[].class
                );

                if (countryData != null) {
                    for (Country country : countryData) {

                        String id = country.getId();
                        String name = country.getName();


                        country.setId(id);
                        country.setName(name);

                        String description = country.getDescription();
                        if (description != null) {

                            if (description.length() > 65535) {
                                country.setDescription(description.substring(0, 65535));
                            }
                        }

                        countries.add(country);
                    }
                }
            } catch (Exception e) {

                System.err.println("Error fetching countries from part: " + part);
                e.printStackTrace();
            }
        }


        if (!countries.isEmpty()) {
            try {
                countryRepository.saveAll(countries);
            } catch (Exception e) {

                System.err.println("Error saving countries to database");
                e.printStackTrace();
            }
        } else {
            System.out.println("No countries fetched to save.");
        }
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountries(String id) {
        return countryRepository.findById(id).orElse(null);
    }


    public Country addCountryWithEvents(Country country) {
        List<Event> events = country.getEvents();

        for (Event event : events) {
            event.setCountry(country);

            if (event.getMedalsBySport() == null) {
                event.setMedalsBySport(new Event.MedalsBySport());
            }

            if (event.getMedalsBySport().getUntil2024() == null) {
                event.getMedalsBySport().setUntil2024(new Event.Until2024());
            }

            if (event.getMedalsBySport().getUntil2024().getSports() == null) {
                event.getMedalsBySport().getUntil2024().setSports(new ArrayList<>());
            }

        }

        country.setEvents(events);
        return countryRepository.save(country);
    }


    public boolean deleteCountryById(String id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}