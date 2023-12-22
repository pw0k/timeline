package pw.timeline.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import pw.timeline.model.post.TimelineCustomRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import(TimelineCustomRepo.class)
class TimelineCustomRepoTest extends BaseIntegrationTest {

    @Autowired
    private TimelineCustomRepo timelineCustomRepo;

    @Test
    void shouldReturn3Records() {
        // Given
        Long userId = 2L; // Replace with your user ID or any necessary setup

        // When
        List<Object[]> result = timelineCustomRepo.findPostsByFollowerId(userId);

        // Then
        assertEquals(3, result.size(), "Size must be the same");
    }
}