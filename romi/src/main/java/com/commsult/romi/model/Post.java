package com.commsult.romi.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String imageUrl;
    private String caption;
    private int likeCount;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    // Constructors, getters, setters
}

