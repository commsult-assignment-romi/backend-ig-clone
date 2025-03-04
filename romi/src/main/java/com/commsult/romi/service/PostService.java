package com.commsult.romi.service;

import com.commsult.romi.model.LikeEntity;
import com.commsult.romi.model.Post;
import com.commsult.romi.model.User;
import com.commsult.romi.repository.LikeRepository;
import com.commsult.romi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public Post createPost(User user, String imageUrl, String caption) {
        Post post = new Post(user, imageUrl, caption);
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post likePost(Long postId, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        Optional<LikeEntity> existingLike = likeRepository.findByPostAndUser(post, user);
        if (existingLike.isEmpty()) {
            LikeEntity like = new LikeEntity(post, user);
            likeRepository.save(like);
            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
        }
        return post;
    }
}
