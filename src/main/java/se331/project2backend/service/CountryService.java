package se331.project2backend.service;

public interface CountryService {
    @Service
    public class CountryService {

        @Autowired
        private CountryRepository countryRepository;

        @Autowired
        private MedalRepository medalRepository;

        public List<Country> getAllCountries() {
            return countryRepository.findAll();
        }

        public List<Medal> getMedalsByCountryId(Long countryId) {
            return medalRepository.findByCountryId(countryId);
        }
    }

}
