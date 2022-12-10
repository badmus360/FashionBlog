package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.CommentDto;
import com.example.week9sq12360.dto.CommentResponse;
import com.example.week9sq12360.entity.Comment;
import com.example.week9sq12360.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UsersService{

    private final CommentRepository commentRepository;

    @Override
    public CommentResponse commentOnPost(CommentDto commentDto) {

        if(commentDto.getMessage() == null){
            throw new RuntimeException("Inputs your comments please!!!");
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        Comment createdComment = commentRepository.save(comment);
        CommentResponse commentResponse = new CommentResponse();
        BeanUtils.copyProperties(createdComment, commentResponse);
        return commentResponse;
    }

    @Override
    public CommentResponse deleteComment(Long commentId) {

        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if(commentOptional.isPresent())
        {
            Comment comment = commentOptional.get();
            commentRepository.deleteById(comment.getId());
        }
        throw new RuntimeException("Comment does not EXIST!!!");
    }
}
