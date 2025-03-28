package com.commsult.romi.controller;

import com.commsult.romi.dto.CreatePostRequest;
import com.commsult.romi.model.Post;
import com.commsult.romi.model.User;
import com.commsult.romi.service.PostService;
import com.commsult.romi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody CreatePostRequest request) {
        User user = userService.findByUsername(request.getUsername());
        return postService.createPost(user, request.getImageUrl(), request.getCaption());
    }

    @PostMapping("/{postId}/like")
    public Post likePost(@PathVariable Long postId, @RequestParam String username) {
        User user = userService.findByUsername(username);
        return postService.likePost(postId, user);
    }
}
