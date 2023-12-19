package pw.timeline.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pw.timeline.model.feed.Feed;
import pw.timeline.model.feed.FeedRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedService {

    private final FeedRepository feedRepository;


    public Feed findById(Long id) {
        return feedRepository.findById(id).orElse(null);
    }

    public Feed save(Feed feed) {
        return feedRepository.save(feed);
    }

    public List<Feed> findAll() {
        return feedRepository.findAll();
    }
}
