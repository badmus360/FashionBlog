package com.example.week9sq12360.controllers;

import com.example.week9sq12360.dto.CommentDto;
import com.example.week9sq12360.dto.CommentResponse;
import com.example.week9sq12360.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/comment")
    public CommentResponse comment(@RequestBody CommentDto commentDto){
        return userService.commentOnPost(commentDto);
    }

    @PostMapping("/{commentId}/comment")
    public CommentResponse deleteComment(@PathVariable Long commentId){
        return userService.deleteComment(commentId);
    }
}
