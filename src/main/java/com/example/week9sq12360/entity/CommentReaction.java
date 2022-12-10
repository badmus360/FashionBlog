package com.example.week9sq12360.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment_reaction")
@Getter
@Setter
public class CommentReaction {
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
