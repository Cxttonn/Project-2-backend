package se331.project2backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2backend.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
//    List<Organizer> findAll();
}
