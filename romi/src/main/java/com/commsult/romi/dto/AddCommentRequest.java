package com.commsult.romi.dto;

import lombok.Data;

@Data
public class AddCommentRequest {
    private Long postId;
    private String username;
    private String text;
}
