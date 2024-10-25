package se331.project2backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2backend.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
//    List<Participant> findAll();
}
