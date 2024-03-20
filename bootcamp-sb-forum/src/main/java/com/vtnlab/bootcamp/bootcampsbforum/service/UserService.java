package com.vtnlab.bootcamp.bootcampsbforum.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtnlab.bootcamp.bootcampsbforum.dto.request.UserPostRequestDTO;
import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;

public interface UserService {
    List<User> getUsers();

    User getUser(int index) ;
    List<Post> getPosts();

    List<Album> getAlbums();

    List<Todo> getTodos();

    List<Comment> getComments();

    List<Photo> getPhotos();

    List<UserEntity> getUserByAddrLatGreaterThan(Double latitute);

    Long countUserByName(String prefix);

    List<UserEntity> getAllByEmailOrPhone(String email, String phone, Sort sort);

    void updateUserEmail ( Long id,String email);
    // List<com.vtnlab.bootcamp.bootcampsbforum.entity.User> findAllByEmailAndPhone(String email, String phone);

    UserEntity updateUserById(Long id, UserEntity user);

    public UserEntity save(UserPostRequestDTO userRequestDTO);
}
