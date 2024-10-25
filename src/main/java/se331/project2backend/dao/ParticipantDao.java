package se331.project2backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project2backend.entity.Participant;


public interface ParticipantDao {
//    Integer getParticipantSize();
//    List<Participant> getParticipants(Integer pageSize, Integer page);
//    Optional<Participant> getParticipant(Long id);
//    Participant save(Participant participant);
    Page<Participant> getParticipant(Pageable pageRequest);

}

