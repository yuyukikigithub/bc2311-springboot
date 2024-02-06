package com.vtnlab.bootcamp.bootcampsbforum.service;

import java.util.List;

import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Album;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Photo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.Todo;
import com.vtnlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {
    List<User> getUsers();

    User getUser(int index) ;
    List<Post> getPosts();

    List<Album> getAlbums();

    List<Todo> getTodos();

    List<Comment> getComments();

    List<Photo> getPhotos();

    

}
