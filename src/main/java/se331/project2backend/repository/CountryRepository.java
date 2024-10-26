package se331.project2backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2backend.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
