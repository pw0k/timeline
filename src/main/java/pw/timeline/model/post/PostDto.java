package pw.timeline.model.post;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {

    private final PostType postType;
    private final String name;
    private final LocalDateTime createdAt;
    private final String title;
    private final String description;
}