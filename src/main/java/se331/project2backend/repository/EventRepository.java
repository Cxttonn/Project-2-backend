package se331.project2backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2backend.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();

    Page<Event> findByTitle(String title, Pageable PageRequest);
    Page<Event> findByTitleContaining(String title, Pageable PageRequest);
    Page<Event> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable PageRequest);
    Page<Event> findByTitleContainingAndDescriptionContaining(String title, String description, Pageable PageRequest);
    Page<Event> findByTitleContainingOrDescriptionContainingOrOrganizer_NameIgnoreCaseContaining(String title, String description, String organizerName, Pageable PageRequest);
}
