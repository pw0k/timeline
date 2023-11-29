package pw.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.feed.model.feed.Feed;
import pw.feed.model.feed.FeedRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("feed")
public class FeedController {
    private FeedRepository feedRepository;

    @GetMapping
    List<Feed> getAll(){
        return feedRepository.findAll();
    }

    @GetMapping("/test")
    String test() {
        return "test";
    }
}
