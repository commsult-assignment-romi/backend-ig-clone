package com.commsult.romi.controller;

import com.commsult.romi.dto.AddCommentRequest;
import com.commsult.romi.model.Comment;
import com.commsult.romi.model.User;
import com.commsult.romi.service.CommentService;
import com.commsult.romi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Comment addComment(@RequestBody AddCommentRequest request) {
        User user = userService.findByUsername(request.getUsername());
        return commentService.addComment(request.getPostId(), user, request.getText());
    }
}
