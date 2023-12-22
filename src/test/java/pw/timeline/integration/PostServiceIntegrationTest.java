package pw.timeline.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import pw.timeline.integration.BaseIntegrationTest;
import pw.timeline.model.post.Post;
import pw.timeline.model.post.PostDto;
import pw.timeline.model.post.PostType;
import pw.timeline.service.post.PostService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import(PostService.class)
@Sql("/db/cleanup.sql")
class PostServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private PostService postService;

    @Test
    void shouldFindAllPostForTimelineAndRightFirstPost() {
        // Given
        Long userId = 2L; // Replace with your test user ID or any necessary setup

        // When
        List<PostDto> posts = postService.findPostsByFollowerId(userId);
        PostDto post = posts.get(0);

        // Then
        assertEquals(3, posts.size(), "Size must be the same");
        assertEquals("Get Schwifty", post.getTitle(), "Title must be the same");
        assertEquals("Schwifty Schwifty Schwifty", post.getDescription(), "Description must be the same");
        assertEquals("Rick Sanchez", post.getName(), "Name must be the same");
        assertEquals(PostType.USER, post.getPostType(), "PostType must be the same");

    }

    @Test
    void shouldFindRightPost() {
        // Given
        Long postId = 1L; // Replace with your test post ID or any necessary setup

        // When
        Post post = postService.findById(postId);

        // Then
        assertEquals("I’m not looking for judgement, just a yes or no", post.getTitle(), "Title must be the same");
    }

    @Test
    void shouldReturnGoodPost() {
        // Given
        Post postToSave = Post.builder()
                .title("title")
                .description("description")
                .userId(8L)
                .build();

        // When
        Post savedPost = postService.save(postToSave);

        // Then
        assertNotNull(savedPost.getId(), "post must have non-null ID");
        assertEquals("title", savedPost.getTitle(), "Title must be the same");
        assertEquals("description", savedPost.getDescription(), "Description must be the same");
        assertEquals(8L, savedPost.getUserId(), "userId must be the same");
    }
}