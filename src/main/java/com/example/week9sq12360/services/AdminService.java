package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.dto.PostDto;
import com.example.week9sq12360.dto.PostResponse;
import org.reactivestreams.Publisher;

public interface AdminService {

    String createAdmin(AdminDto adminDto);
    PostResponse createPost(PostDto postDto);
    PostResponse updatePost(PostDto postDto, Long postId);
    PostResponse deletePost(Long postId);
}
