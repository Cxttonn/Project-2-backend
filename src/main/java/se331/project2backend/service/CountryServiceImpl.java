package se331.project2backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.project2backend.entity.Country;
import se331.project2backend.entity.Event;
import se331.project2backend.repository.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl extends CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountries(String id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country addCountryWithEvents(Country country) {
        for (Event event : country.getEvents()) {
            event.setCountry(country);
        }
        return countryRepository.save(country);
    }

    @Override
    public boolean deleteCountryById(String id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}