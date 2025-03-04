package com.commsult.romi.service;

import com.commsult.romi.model.Comment;
import com.commsult.romi.model.Post;
import com.commsult.romi.model.User;
import com.commsult.romi.repository.CommentRepository;
import com.commsult.romi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public Comment addComment(Long postId, User user, String text) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment(post, user, text);
        return commentRepository.save(comment);
    }
}
