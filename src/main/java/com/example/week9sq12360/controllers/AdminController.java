package com.example.week9sq12360.controllers;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.dto.PostDto;
import com.example.week9sq12360.dto.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.week9sq12360.services.AdminServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;

    @PostMapping("/sign-up")
    public String addAdmin(@RequestBody AdminDto adminDto){
        return adminService.createAdmin(adminDto);
    }
    @PostMapping("/create_post")
    public PostResponse createPost(@RequestBody PostDto postDto){
        return adminService.createPost(postDto);
    }
    @PostMapping("/{postId}/create_post")
    public PostResponse postUpdate(@RequestBody PostDto postDto, @PathVariable Long postId){
        return adminService.updatePost(postDto, postId);
    }
    @PostMapping("/{postId}")
    public PostResponse deletePost(@PathVariable Long postId){
        return adminService.deletePost(postId);
    }
}
