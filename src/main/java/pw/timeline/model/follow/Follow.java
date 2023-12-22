package pw.timeline.model.follow;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import pw.timeline.model.Group;
import pw.timeline.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "follow")
public class Follow {

    @EmbeddedId
    private FollowId id;

    @ManyToOne
    @MapsId("follower")
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne
    @MapsId("followeeUser")
    @JoinColumn(name = "followee_user_id")
    private User followeeUser;

    @ManyToOne
    @MapsId("followeeGroup")
    @JoinColumn(name = "followee_group_id")
    private Group followeeGroup;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
