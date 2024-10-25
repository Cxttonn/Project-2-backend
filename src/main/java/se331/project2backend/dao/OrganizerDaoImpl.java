package se331.project2backend.dao;//package se331.lab.dao;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import se331.lab.entity.Organizer;
//import se331.lab.repository.OrganizerRepository;
//
//import java.util.Optional;
//
//@Repository
//@RequiredArgsConstructor
//public class OrganizerDaoImpl implements OrganizerDao {
//    final OrganizerRepository organizerRepository;
//
//    @Override
//    public Page<Organizer> getOrganizer(Pageable pageRequest) {
//        return organizerRepository.findAll(pageRequest);
//    }
//
//    @Override
//    public Optional<Organizer> findById(long id){
//        return organizerRepository.findById(id);
//    }
//
//    @Override
//    public Organizer save(Organizer organizer) {
//        return organizerRepository.save(organizer);
//    }
//
//    @Override
//    public Organizer getOrganizer(long id) {
//        return organizerRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
//        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
//        return organizerRepository.findAll(pageRequest);
//    }
//
//    @Override
//    public Integer getOrganizerSize() {
//        return Math.toIntExact(organizerRepository.count());
//    }
//
//
//
//}
