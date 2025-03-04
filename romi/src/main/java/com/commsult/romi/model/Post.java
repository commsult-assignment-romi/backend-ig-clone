package com.commsult.romi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String caption;

    @Column(name = "like_count")
    private int likeCount = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    // Custom constructor for creating a post
    public Post(User user, String imageUrl, String caption) {
        this.user = user;
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.likeCount = 0;
        this.createdAt = LocalDateTime.now();
    }
}
