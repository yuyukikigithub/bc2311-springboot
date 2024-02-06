package com.vtnlab.bootcamp.bootcampsbforum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {
    @GetMapping(value="/users")
    List<User> getUsers();

    @GetMapping(value="/posts")
    List<Post> getPosts();

    @GetMapping(value="/albums")
    List<Album> getAlbums();

    @GetMapping(value="/todos")
    List<Todo> getTodos();

    @GetMapping(value="/comments")
    List<Comment> getComments();

    @GetMapping(value="/photos")
    List<Photo> getPhotos();
    

}
