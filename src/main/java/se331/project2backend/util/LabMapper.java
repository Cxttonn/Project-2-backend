//package se331.project2backend.util;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//import se331.project2backend.entity.*;
//
//import java.util.List;
//
//@Mapper
//public interface LabMapper {
//    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
//    @Mapping(source = "participants", target = "participants")
//    EventDTO getEventDTO(Event event);
//    List<EventDTO> getEventDTO(List<Event> events);
//    OrganizerDTO getOrganizerDTO(Organizer organizer);
//    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizer);
//    ParticipantDTO getParticipantDTO(Participant participant);
//    List<ParticipantEventDTO> getParticipantEventDTO(List<Participant> participants);
//    @Mapping(source = "eventHistory", target = "events")
//    ParticipantEventDTO toParticipantEventDTO(Participant participant);
////    @Mapping(source = "user.roles", target = "roles");
//    OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);
//
//}