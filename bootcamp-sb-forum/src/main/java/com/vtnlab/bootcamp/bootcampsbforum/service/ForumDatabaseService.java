package com.vtnlab.bootcamp.bootcampsbforum.service;

import java.util.List;

import com.vtnlab.bootcamp.bootcampsbforum.entity.UserEntity;

public interface ForumDatabaseService {
    UserEntity saveUser(UserEntity user);
    List<UserEntity> saveUsers(List<UserEntity> users);
    void deleteAllUsers();

}
