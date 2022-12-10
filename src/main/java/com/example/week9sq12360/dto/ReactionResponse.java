package com.example.week9sq12360.dto;

import lombok.Data;

@Data
public class ReactionResponse {
    private boolean liked;
    private Long postId;
    private Long userId;
}
