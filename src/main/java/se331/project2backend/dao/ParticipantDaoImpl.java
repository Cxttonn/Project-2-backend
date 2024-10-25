package se331.project2backend.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project2backend.entity.Participant;
import se331.project2backend.repository.ParticipantRepository;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao {
final ParticipantRepository participantRepository;
    @Override
    public Page<Participant> getParticipant(Pageable pageRequest){
        return participantRepository.findAll(pageRequest);
    }
}
