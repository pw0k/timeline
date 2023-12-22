package pw.timeline.service.post;

import org.springframework.stereotype.Component;
import pw.timeline.model.post.PostDto;
import pw.timeline.model.post.PostType;

import java.sql.Timestamp;
import java.util.Arrays;

@Component
public class PostDtoConverter {

    public PostDto convertToPostDto(Object[] result) {
        PostType postType = result[0] == null ? PostType.GROUP : PostType.USER;
        Arrays.stream(result).forEach(System.out::println);
        return PostDto.builder()
                .postType(postType)
                .name(postType == PostType.USER ? (String) result[0] : (String) result[1])
                .createdAt(((Timestamp) result[2]).toLocalDateTime())
                .title((String) result[3])
                .description((String) result[4])
                .build();
    }
}
