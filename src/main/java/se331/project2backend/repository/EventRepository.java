package se331.project2backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project2backend.entity.Event;

public interface EventRepository extends JpaRepository<Event, String> {
    Page<Event> findByNameContaining(String name, Pageable pageable);}

