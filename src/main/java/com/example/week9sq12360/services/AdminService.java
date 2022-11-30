package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.dto.PostDto;
import com.example.week9sq12360.dto.PostResponse;

public interface AdminService {

    public String createAdmin(AdminDto adminDto);

    PostResponse createPost(PostDto postDto);

}
