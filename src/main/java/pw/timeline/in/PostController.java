package pw.timeline.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.timeline.model.post.Post;
import pw.timeline.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
//TODO swagger
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getAll() {
        return postService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    //TODO 201
    @PostMapping
    public Post savePost(@RequestBody Post post) {
        return postService.save(post);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    //TODO Display name and
    //@ControllerAdvice and @ExceptionHandler annotations.
}
