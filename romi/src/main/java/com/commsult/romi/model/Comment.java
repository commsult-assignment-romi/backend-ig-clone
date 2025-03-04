package com.commsult.romi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Custom constructor for adding a comment
    public Comment(Post post, User user, String text) {
        this.post = post;
        this.user = user;
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }
}
