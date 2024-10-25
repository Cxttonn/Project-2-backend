package se331.project2backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.project2backend.entity.Countries;
import se331.project2backend.entity.Medals;
import se331.project2backend.service.CountryService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryController {

        @Autowired
        private CountryService countryService;

        @GetMapping("/countries")
        public List<Countries> getCountries() {
            return countryService.getAllCountries();
        }

        @GetMapping("/countries/{id}/medals")
        public List<Medals> getMedalsByCountryId(@PathVariable Long id) {
            return countryService.getMedalsByCountryId(id);
        }
    }
