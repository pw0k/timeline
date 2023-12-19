package pw.timeline.model.feed;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Post {

    @Id
    Long id;
    String title;
    String description;
    Long userId;
    //todo dateeee )
}
