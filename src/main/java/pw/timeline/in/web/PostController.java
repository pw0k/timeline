package pw.timeline.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.timeline.model.post.Post;
import pw.timeline.model.post.PostDto;
import pw.timeline.service.post.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
//TODO swagger
public class PostController {

    private final PostService postService;

    @GetMapping("timelines/{userId}")
    public ResponseEntity<List<PostDto>> findPostsByFollowerId(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.findPostsByFollowerId(userId));
    }

//    @GetMapping("posts")
//    public List<Post> getAll() {
//        return postService.findAll();
//    }

    @GetMapping("posts/{userId}")
    public ResponseEntity<Post> findById(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.findById(userId));
    }

    //TODO 201
    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return postService.save(post);
    }

    //TODO Display name and
    //@ControllerAdvice and @ExceptionHandler annotations.
}
