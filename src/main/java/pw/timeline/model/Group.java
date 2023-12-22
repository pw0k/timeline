package pw.timeline.model;

import jakarta.persistence.*;
import lombok.*;
import pw.timeline.model.follow.Follow;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "tm_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String groupname;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "followeeGroup")
    private Set<Follow> followeeSet;
}
