package com.example.week9sq12360.controllers;

import com.example.week9sq12360.dto.ReactionDto;
import com.example.week9sq12360.dto.ReactionResponse;
import com.example.week9sq12360.services.ReactionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/reaction")
public class ReactionController {

    private final ReactionServiceImpl reactionService;

    @PostMapping("/{postId}/reaction")
    public ReactionResponse likeAndUnlikePost(@RequestBody ReactionDto reactionDto, @PathVariable Long postId){
        return reactionService.likeAndUnlikePost(reactionDto, postId);
    }
}
