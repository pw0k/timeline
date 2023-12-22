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
@Table(name = "tm_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "follower")
    private Set<Follow> followerSet;

    @OneToMany(mappedBy = "followeeUser")
    private Set<Follow> followeeSet;

}
