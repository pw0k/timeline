package pw.feed.model.feed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("feed")
@NoArgsConstructor
@Getter
@Setter
public class Feed {

    @Id
    private String id;

    private String title;
    private String description;

}
