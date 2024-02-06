package com.vtnlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtnlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value="api/v1")
public class UserController implements UserOperation{

    @Autowired
    private UserService userService;

	@Override
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@Override
	public List<Post> getPosts() {
		return userService.getPosts();
	}

	@Override
	public List<Album> getAlbums() {
		return userService.getAlbums();
	}

	@Override
	public List<Todo> getTodos() {
		return userService.getTodos();
	}

	@Override
	public List<Comment> getComments() {
		return userService.getComments();
	}

	@Override
	public List<Photo> getPhotos() {
		return userService.getPhotos();
	}
    
}
