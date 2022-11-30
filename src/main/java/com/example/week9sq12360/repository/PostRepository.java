package com.example.week9sq12360.repository;

import com.example.week9sq12360.dto.AdminDto;
import com.example.week9sq12360.dto.PostDto;
import com.example.week9sq12360.entity.Admin;
import com.example.week9sq12360.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    Post savePost(PostDto postDto);

}
