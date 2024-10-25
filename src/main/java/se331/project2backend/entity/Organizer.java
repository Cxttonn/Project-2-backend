package se331.project2backend.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.project2backend.security.user.User;


import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    @OneToMany(mappedBy = "organizer")
    @Builder.Default
    List<Event> ownEvents = new ArrayList<>();
    @ElementCollection
    List<String> images;
    @OneToOne
    User user;
}
