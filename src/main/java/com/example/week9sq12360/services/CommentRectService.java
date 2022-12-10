package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.CommentReactionDto;
import com.example.week9sq12360.dto.CommentReactionResponse;

public interface CommentRectService {

    CommentReactionResponse commentReactServ(CommentReactionDto commentReactServDto, Long commentId);

}
