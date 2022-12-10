package com.example.week9sq12360.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "post_like")
@Entity
@Getter
@Setter
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "liked")
    private boolean liked;
    @Column(name = "postId")
    private Long postId;
    @Column(name = "userId")
    private Long userId;



}
