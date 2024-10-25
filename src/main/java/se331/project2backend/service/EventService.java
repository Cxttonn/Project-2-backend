package se331.project2backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project2backend.entity.Event;


public interface EventService {
    Integer getEventSize();
    Page<Event> getEvents (Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save(Event event);
    Page<Event> getEvents(String title, Pageable pageable);
}
