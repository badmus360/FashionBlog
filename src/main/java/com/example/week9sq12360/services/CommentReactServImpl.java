package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.CommentReactionDto;
import com.example.week9sq12360.dto.CommentReactionResponse;
import com.example.week9sq12360.entity.CommentReaction;
import com.example.week9sq12360.repository.CommentReactRepo;
import com.example.week9sq12360.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentReactServImpl implements CommentRectService{

    private final CommentReactRepo commentReactRepo;
    private final CommentRepository commentRepository;


    @Override
    public CommentReactionResponse commentReactServ(CommentReactionDto commentReactionDto, Long commentId) {

        CommentReaction commentReaction = new CommentReaction();
        CommentReactionResponse commentReactionResponse = new CommentReactionResponse();

        if(commentRepository.existsById(commentId))
        {
            if(commentReaction.isLiked()){
                commentReaction.setLiked(false);
                commentReactRepo.save(commentReaction);
            }
            else{
                commentReaction.setLiked(true);
                commentReactRepo.save(commentReaction);
            }
        }
        BeanUtils.copyProperties(commentReactRepo, commentReactionResponse);
        return commentReactionResponse;

    }
}
