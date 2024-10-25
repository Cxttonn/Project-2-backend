package se331.project2backend.service;

import org.springframework.data.domain.Page;
import se331.project2backend.entity.Participant;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllParticipants();
    Page<Participant> getParticipant(Integer page, Integer pageSize);
}
