package com.commsult.romi.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String username;
    private String imageUrl;
    private String caption;
}
