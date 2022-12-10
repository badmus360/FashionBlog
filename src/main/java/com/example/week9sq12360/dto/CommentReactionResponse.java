package com.example.week9sq12360.dto;

import lombok.Data;

@Data
public class CommentReactionResponse {
    private boolean liked;
    private Long postId;
    private Long userId;
}
