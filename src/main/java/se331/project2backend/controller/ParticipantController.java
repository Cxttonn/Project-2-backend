package se331.project2backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.project2backend.service.ParticipantService;
import se331.project2backend.util.LabMapper;

@RestController
//@RequestMapping("participants")
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("/participants")
    ResponseEntity<?> getParticipants() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantEventDTO(participantService.getAllParticipants()));
    }
}
