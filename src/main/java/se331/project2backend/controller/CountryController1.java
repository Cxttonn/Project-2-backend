package se331.project2backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.project2backend.entity.Country;
import se331.project2backend.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController1 {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable String id) {
        return countryService.getCountries(id);
    }
}