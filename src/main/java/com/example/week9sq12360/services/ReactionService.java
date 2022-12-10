package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.ReactionDto;
import com.example.week9sq12360.dto.ReactionResponse;
import com.example.week9sq12360.entity.Reaction;

public interface ReactionService {

    ReactionResponse likeAndUnlikePost(ReactionDto reactionDto, Long postId);

}
