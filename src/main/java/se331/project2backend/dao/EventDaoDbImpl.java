package se331.project2backend.dao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project2backend.entity.Event;
import se331.project2backend.repository.EventRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class EventDaoDbImpl implements EventDao{
    final EventRepository eventRepository;

//    public EventDaoDbImpl(EventRepository eventRepository) {
//        this.eventRepository = eventRepository;
//    }

    @Override
    public Integer getEventSize(){
        return Math.toIntExact(eventRepository.count());
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page){
        long totalEvents = eventRepository.count();
        pageSize = pageSize == null ? (int) totalEvents : pageSize;
        page = page== null || page < 1 ? 0 : page -1;
        return eventRepository.findAll(PageRequest.of(page ,pageSize));
    }

    @Override
    public Event getEvent(Long id){
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event){
        return eventRepository.save(event);
    }

    @Override
    public Page<Event> getEvents(String title, Pageable page){
        return eventRepository.findByTitleContainingOrDescriptionContainingOrOrganizer_NameIgnoreCaseContaining(title,title,title,page);
    }
}
