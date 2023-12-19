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
import pw.timeline.model.feed.Feed;
import pw.timeline.service.FeedService;

import java.util.List;

//todo @JsonTest ??
@WebMvcTest(FeedController.class)
class FeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FeedService feedService;

    @Test
    void findAllShouldReturnValidFeeds() throws Exception {
        //given
        when(feedService.findAll()).thenReturn(getFeeds());

        //then
        this.mockMvc.perform(get("/feed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(jsonPath("$.[1].id").value(2));
    }

    @Test
    void findByIdShouldReturnValidFeed() throws Exception {
        //given
        when(feedService.findById(1L)).thenReturn(getFeeds().get(0));

        //when

        //then
        this.mockMvc.perform(get("/feed/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("title1"))
                .andExpect(jsonPath("$.description").value("desc1"))
                .andDo(print());
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