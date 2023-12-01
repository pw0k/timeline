package pw.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.feed.model.feed.Feed;
import pw.feed.model.feed.FeedRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("feed")
public class FeedController {

    private final FeedRepository feedRepository;

    @GetMapping
    public List<Feed> getAll() {
        return feedRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Feed> saveFeed(@RequestBody Feed feed) {
        return ResponseEntity.ok(feedRepository.save(feed));
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
