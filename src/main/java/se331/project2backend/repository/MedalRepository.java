package se331.project2backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2backend.entity.Countries;
import se331.project2backend.entity.Medals;

public interface MedalRepository extends JpaRepository<Medals, Long> {
}
