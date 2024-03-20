package com.vtnlab.bootcamp.bootcampsbforum.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;

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
    
    @GetMapping(value="/users/count")
    ApiResp<Long> countUserByName(@RequestParam(value="prefix") String prefix);

    @GetMapping(value="/users/lat/{lat}")
    ApiResp<List<UserEntity>> getUsersByLatGtrThan(@PathVariable(value="lat") String latitute); 

    @GetMapping(value="/users/email/{email}/phone/{phone}")
    ApiResp<List<UserEntity>> getUserByEmailAndPhone( @PathVariable String email, @PathVariable String phone); 

    @PostMapping(value="/users/{id}/{email}")
    ApiResp<Void> updateUserEmailById(@PathVariable Long id, @PathVariable String email);

    @PutMapping(value="/users/id/{userId}")
    ApiResp<UserEntity> updateUser(@PathVariable Long userId, @RequestBody UserEntity user);

    @PostMapping(value="/user")
    ApiResp<UserEntity> save(@RequestBody UserPostRequestDTO userRequestDTO);

}
