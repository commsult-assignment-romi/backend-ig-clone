package com.commsult.romi.controller;

import com.commsult.romi.dto.AddCommentRequest;
import com.commsult.romi.model.Comment;
import com.commsult.romi.model.User;
import com.commsult.romi.service.CommentService;
import com.commsult.romi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    @PostMapping
    public Comment addComment(@RequestBody AddCommentRequest request) {
        User user = userService.findByUsername(request.getUsername());
        return commentService.addComment(request.getPostId(), user, request.getText());
    }
}
