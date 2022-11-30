package com.example.week9sq12360.services;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.dto.PostDto;
import com.example.week9sq12360.dto.PostResponse;
import com.example.week9sq12360.entity.Admin;
import com.example.week9sq12360.entity.Post;
import com.example.week9sq12360.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.example.week9sq12360.repository.AdminRepository;
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    private final PostRepository postRepository;

    @Override
    public String createAdmin(AdminDto adminDto) {
        System.out.println(adminDto);

        if(adminDto.getFirstName().equals("") || adminDto.getSurName().equals("")
        || adminDto.getEmail().equals("") || adminDto.getPassword().equals("")){
            throw new RuntimeException("Please input the complete required field!!!");
        }
        Admin adminEntityToSave = new Admin();
        BeanUtils.copyProperties(adminDto, adminEntityToSave);
        System.out.println(adminEntityToSave);
//      Admin adminEntityCreated = adminRepository.save(adminEntityToSave);
        adminRepository.save(adminEntityToSave);
        return "created";
    }

    @Override
    public PostResponse createPost(PostDto postDto) {

        if(postDto.getMessage() == null){
            throw new RuntimeException("Input contents, Please!!!");
        }
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        Post createdPost = postRepository.save(post);
        PostResponse postResponse = new PostResponse();
        BeanUtils.copyProperties(createdPost, postResponse);
        return postResponse;
    }
}
