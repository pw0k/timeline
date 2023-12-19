package pw.timeline.model.feed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//TODO https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-postgresql/#testing-rest-services-rest-assured-and-testcontainers
//@DataJpaTest(showSql = false)
// disabled or turn off the transactional and roll back
// @Transactional(propagation = Propagation.NOT_SUPPORTED)
// We dont want the H2 in-memory database
// We will provide a custom `test container` as DataSource, don't replace it.
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FeedRepositoryTest {

    @Autowired
    private FeedRepository feedRepository;

    // static, all tests share this postgres container
//    @Container
//    @ServiceConnection
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
//            "postgres:15-alpine"
//    );

    @Test
    public void testSave() {
        Feed feed1 = getFeeds().get(0);
        feedRepository.save(feed1);

        Feed feed2 =  feedRepository.findById(1L).orElseThrow();

        Long feedId = feed1.getId();
        assertEquals(1L,feed1.getId());
        assertEquals(1L, feed2.getId());
    }

    private void assertArrayEquals(long l, Long id) {
    }


    private List<Feed> getFeeds() {
        Feed feed1 = Feed.builder()
                .id(1L)
                .title("title1")
                .description("desc1")
                .build();
        Feed feed2 = Feed.builder()
                .id(2L)
                .title("title2")
                .description("desc2")
                .build();

        return List.of(feed1, feed2);
    }

}