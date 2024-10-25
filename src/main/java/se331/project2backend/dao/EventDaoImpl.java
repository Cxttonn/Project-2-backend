package se331.project2backend.dao;//package se331.lab.dao;
//import jakarta.annotation.PostConstruct;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import se331.lab.entity.Event;
//import se331.lab.repository.EventRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@Profile("manual")
//public class EventDaoImpl implements EventDao {
//    List<Event> eventList;
//    final EventRepository eventRepository;
//
//    public EventDaoImpl(EventRepository eventRepository) {
//        this.eventRepository = eventRepository;
//    }
//
//    @Override
//    public Integer getEventSize() {
//        return Math.toIntExact(eventRepository.count());
//    }
//
//    @Override
//    public Page<Event> getEvents(Integer pageSize, Integer page) {
//        long totalEvents = eventRepository.count();
//        pageSize = pageSize == null ? (int) totalEvents : pageSize;
//        page = page == null ? 0 : page - 1;
//        return eventRepository.findAll(PageRequest.of(page - 1, pageSize));
//    }
//
//    @Override
//    public Event getEvent(Long id) {
//        return eventRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Event save(Event event) {
//        return eventRepository.save(event);
//    }
//
////    @Override
////    public Page<Event> getEvents(String title, Pageable page) {
////        return eventRepository.findByTitleContainingOrDescriptionContainingOrOrganizer_NameContaining(title, title,title, page);
////    }
//}
