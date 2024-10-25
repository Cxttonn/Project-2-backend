package se331.project2backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    List<OrganizerOwnEventsDTO> ownEvents  = new ArrayList<>();
    List<String> images;
}
