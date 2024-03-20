package com.vtnlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtnlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.service.UserService;
import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtnlab.bootcamp.bootcampsbforum.infra.ApiResp;

@RestController
@RequestMapping(value="/api/v1")
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

	@Override
	public ApiResp<Long> countUserByName(String prefix) {
		return ApiResp.<Long>builder()
					.ok()
					.data(userService.countUserByName(prefix))
					.build();
	}

	@Override
	public ApiResp<List<UserEntity>> getUsersByLatGtrThan(String latitute) {
		List<UserEntity> users =   userService.getUserByAddrLatGreaterThan(0.0);
		return ApiResp.<List<UserEntity>>builder()
						.ok()
						.data(users)
						.build();
	}

	@Override
	public ApiResp<List<UserEntity>> getUserByEmailAndPhone(String email, String phone) {
		Sort sortByEmailDesc = Sort.by("email").ascending();
		List<UserEntity> users = userService.getAllByEmailOrPhone(email,phone,sortByEmailDesc);
		return ApiResp.<List<UserEntity>>builder()
					.ok()
					.data(users)
					.build();
	}

	@Override
	public ApiResp<Void> updateUserEmailById(Long id, String email) {
		 userService.updateUserEmail(id, email);
		 return ApiResp.<Void>builder()
		 				.ok()
						.data(null)
						.build();
	}

	@Override
	public ApiResp<UserEntity> updateUser(Long userId, UserEntity user) {
		return ApiResp.<UserEntity>builder()
						.ok()
						.data(userService.updateUserById(userId, user))
						.build();
	}

	@Override
	public ApiResp<UserEntity> save(UserPostRequestDTO userRequestDTO) {
    return ApiResp.<UserEntity>builder() //
        .ok() //
        .data(userService.save(userRequestDTO)) //
        .build();
  }
    
}
