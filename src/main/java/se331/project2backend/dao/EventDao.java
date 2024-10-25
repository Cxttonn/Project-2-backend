package se331.project2backend.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project2backend.entity.Event;


public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save(Event event);
    Page<Event> getEvents(String name, Pageable page);
}
