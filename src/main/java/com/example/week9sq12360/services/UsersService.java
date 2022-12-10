package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.CommentDto;
import com.example.week9sq12360.dto.CommentResponse;
import com.example.week9sq12360.dto.PostResponse;
import org.springframework.stereotype.Service;


public interface UsersService {

    CommentResponse commentOnPost(CommentDto commentDto);

    CommentResponse deleteComment(Long commentId);

}
