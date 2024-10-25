package se331.project2backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.project2backend.entity.Countries;

@Repository
public interface CountryRepository extends JpaRepository<Countries, Long> {
}
