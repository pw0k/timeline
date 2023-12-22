package pw.timeline.model.follow;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowId implements Serializable {

    private Long follower;
    private Long followeeUser;
    private Long followeeGroup;
}
