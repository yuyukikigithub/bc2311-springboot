package com.vtnlab.bootcamp.bootcampsbforum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;

@Service
public interface PostService{
    List<Post> getPostsFromJPH();
}
