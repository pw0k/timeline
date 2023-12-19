package pw.timeline.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.timeline.model.feed.Feed;
import pw.timeline.service.FeedService;

import java.util.List;

@RestController
@RequiredArgsConstructor
//TODO name convension feeds ??
//TODO swagger
@RequestMapping("feed")
public class FeedController {

    private final FeedService feedService;

    @GetMapping
    public List<Feed> getAll() {
        return feedService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Feed> findById(@PathVariable Long id) {
        return ResponseEntity.ok(feedService.findById(id));
    }

    //TODO 201
    @PostMapping
//    public ResponseEntity<Feed> saveFeed(@RequestBody Feed feed) {
//        return ResponseEntity.ok(feedService.save(feed));
    public Feed saveFeed(@RequestBody Feed feed) {
        return feedService.save(feed);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    //TODO Display name and
    //@ControllerAdvice and @ExceptionHandler annotations.
}
