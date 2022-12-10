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

import java.util.Optional;

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

    @Override
    public PostResponse updatePost(PostDto postDto, Long postId) {

        Optional<Post> postOptional = postRepository.findById(postId);
        if(postOptional.isPresent())
        {
            Post post = postOptional.get();
            BeanUtils.copyProperties(postDto, post);
            Post updatedPost = postRepository.save(post);
            PostResponse postResponse = new PostResponse();
            BeanUtils.copyProperties(updatedPost, postResponse);
            return postResponse;
        }
        throw new RuntimeException("Update ERROR!!!");
    }

    @Override
    public PostResponse deletePost(Long postId) {

        Optional<Post> postOptional = postRepository.findById(postId);
        if(postOptional.isPresent())
        {
            Post post = postOptional.get();
            postRepository.deleteById(post.getId());
        }
        throw new RuntimeException("Post does not EXIST!!!");
    }


}
