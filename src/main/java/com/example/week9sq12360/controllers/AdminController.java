package com.example.week9sq12360.controllers;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.dto.PostDto;
import com.example.week9sq12360.dto.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.week9sq12360.services.AdminServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    private final AdminServiceImpl adminService;

    @PostMapping("/sign-up")
    public String addAdmin(@RequestBody AdminDto adminDto){
        System.out.println("i am in the add admin");
        return adminService.createAdmin(adminDto);
    }

    @PostMapping("/create_post")
    public PostResponse createPost(@RequestBody PostDto postDto){
        return adminService.createPost(postDto);
    }
}
