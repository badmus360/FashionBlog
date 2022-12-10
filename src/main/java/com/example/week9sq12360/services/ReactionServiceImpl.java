package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.ReactionDto;
import com.example.week9sq12360.dto.ReactionResponse;
import com.example.week9sq12360.entity.Post;
import com.example.week9sq12360.entity.Reaction;
import com.example.week9sq12360.entity.Users;
import com.example.week9sq12360.repository.PostRepository;
import com.example.week9sq12360.repository.ReactionRepository;
import lombok.AllArgsConstructor;
//import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReactionServiceImpl implements ReactionService{
    private final ReactionRepository reactionRepository;

    private final PostRepository postRepository;

    @Override
    public ReactionResponse likeAndUnlikePost(ReactionDto reactionDto, Long postId) {

        Reaction reaction = new Reaction();
        ReactionResponse reactionResponse = new ReactionResponse();

        if(postRepository.existsById(postId)){
            if(reactionDto.isLiked()){
                reaction.setLiked(false);
                reactionRepository.save(reaction);
            }
            else{
                reaction.setLiked(true);
                reactionRepository.save(reaction);
            }
        }
        BeanUtils.copyProperties(reactionRepository, reactionResponse);
        return reactionResponse;
    }
}
