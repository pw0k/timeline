package pw.timeline.model.post;

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
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    // static, all tests share this postgres container
//    @Container
//    @ServiceConnection
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
//            "postgres:15-alpine"
//    );

    @Test
    public void testSave() {
        Post post1 = getPosts().get(0);
        postRepository.save(post1);

        Post post2 =  postRepository.findById(1L).orElseThrow();

        Long postId = post1.getId();
        assertEquals(1L,post1.getId());
        assertEquals(1L, post1.getId());
    }

    private void assertArrayEquals(long l, Long id) {
    }


    private List<Post> getPosts() {
        Post post1 = Post.builder()
                .id(1L)
                .title("title1")
                .description("desc1")
                .build();
        Post post2 = Post.builder()
                .id(2L)
                .title("title2")
                .description("desc2")
                .build();

        return List.of(post1, post2);
    }

}