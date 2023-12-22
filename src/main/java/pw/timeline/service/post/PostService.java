package pw.timeline.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pw.timeline.model.post.Post;
import pw.timeline.model.post.PostDto;
import pw.timeline.model.post.PostRepository;
import pw.timeline.model.post.TimelineCustomRepo;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final TimelineCustomRepo timelineCustomRepo;
    private final PostDtoConverter postDtoConverter;

    public List<PostDto> findPostsByFollowerId(Long userId) {
        return timelineCustomRepo.findPostsByFollowerId(userId).stream()
                .map(postDtoConverter::convertToPostDto)
                .collect(Collectors.toList());
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    //todo delete ??
    //todo find all by user id ?? self timeline and maybe cashing it ?

}
