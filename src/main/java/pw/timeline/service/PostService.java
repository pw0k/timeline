package pw.timeline.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pw.timeline.model.post.Post;
import pw.timeline.model.post.PostRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;


    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
