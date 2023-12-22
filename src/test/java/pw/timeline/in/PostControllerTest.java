package pw.timeline.in;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pw.timeline.in.web.PostController;
import pw.timeline.model.post.Post;
import pw.timeline.service.post.PostService;

import java.util.HashMap;
import java.util.List;

//todo @JsonTest ??
//todo check error - not found for example and 201 created
@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

//    @Test
//    void findAllShouldReturnValidPosts() throws Exception {
//        //given
//        when(postService.findAll()).thenReturn(getPosts());
//
//        //then
//        this.mockMvc.perform(get("/posts"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2))
//                .andExpect(jsonPath("$.[0].id").value(1))
//                .andExpect(jsonPath("$.[1].id").value(2));
//    }

    @Test
    void findByIdShouldReturnValidPost() throws Exception {
        //given
        when(postService.findById(1L)).thenReturn(getPosts().get(0));

        //when

        //then
        this.mockMvc.perform(get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("title1"))
                .andExpect(jsonPath("$.description").value("desc1"))
                .andDo(print());
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