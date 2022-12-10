package com.example.week9sq12360.controllers;

import com.example.week9sq12360.dto.CommentReactionDto;
import com.example.week9sq12360.dto.CommentReactionResponse;
import com.example.week9sq12360.services.CommentReactServImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment_reaction")
public class CommentReactionController {

    private final CommentReactServImpl commentReactServ;
    @PostMapping("/{commentId}/comment_reaction")
    public CommentReactionResponse commentReactServ(@RequestBody CommentReactionDto commentReactionDto, @PathVariable Long commentId){
        return commentReactServ.commentReactServ(commentReactionDto, commentId);
    }

}
